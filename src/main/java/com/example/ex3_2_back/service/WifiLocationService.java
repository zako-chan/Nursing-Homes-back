package com.example.ex3_2_back.service;

import com.example.ex3_2_back.domain.wifiLocation.ElderlyPosition;
import com.example.ex3_2_back.entity.Position;
import com.example.ex3_2_back.entity.WifiInfo;
import com.example.ex3_2_back.repository.PositionRepository;
import com.example.ex3_2_back.repository.WifiInfoRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 建立wifi指纹数据库服务
 */
@Slf4j
@Service
public class WifiLocationService {

    Jedis jedis;
    @Autowired
    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    PositionRepository positionRepository;
    @Autowired
    public void setPositionRepository(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    WifiInfoRepository wifiInfoRepository;
    @Autowired
    public void setWifiInfoRepository(WifiInfoRepository wifiInfoRepository) {
        this.wifiInfoRepository = wifiInfoRepository;
    }

    private static final int K = 5;

//    private List<Position> positionCache;

    @Cacheable(value = "positions")
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

//    @PostConstruct
//    public void init() {
//        positionCache = positionRepository.findAll();
//    }

    public void savePositionWithWifiInfo(double x, double y, double z, Set<WifiInfo> wifiInfos) {
        Position position = new Position();
        position.setX(x);
        position.setY(y);
        position.setZ(z);

        for (WifiInfo wifiInfo : wifiInfos) {
            wifiInfo.setPosition(position);
        }

        position.setWifiInfos(wifiInfos);
        positionRepository.save(position);
    }

    public Position predictPosition(List<WifiInfo> wifiInfoList) {
//        Collection<Position> positions = positionCache;
        List<Position> positions = getAllPositions();

        // 计算每个位置与输入WIFI信息之间的距离
        Map<Position,Double> distanceMap = new HashMap<>();
        for(Position position:positions){
            double distance = calculateDistance(position,wifiInfoList);
            distanceMap.put(position,distance);
        }

        // 找到距离最小的K个位置
        List<Map.Entry<Position, Double>> nearestNeighbors = distanceMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(K)
                .collect(Collectors.toList());

        // 计算 K 个最近邻位置的平均值，作为预测位置
        double x = 0, y = 0, z = 0;
        for (Map.Entry<Position, Double> entry : nearestNeighbors) {
            x += entry.getKey().getX();
            y += entry.getKey().getY();
            z += entry.getKey().getZ();
        }
        x /= K;
        y /= K;
        z /= Math.round(z / K); // 将 z 取整

        Position predictedPosition = new Position();
        predictedPosition.setX(x);
        predictedPosition.setY(y);
        predictedPosition.setZ(z);

        return predictedPosition;
    }

    private double calculateDistance(Position position, List<WifiInfo> inputWiFiInfos) {
        Set<WifiInfo> positionWiFiInfos = position.getWifiInfos();
        double distance = 0;
        int count = 0;
        for (WifiInfo inputWiFiInfo : inputWiFiInfos) {
            for (WifiInfo positionWiFiInfo : positionWiFiInfos) {
                if (inputWiFiInfo.getBssid().equals(positionWiFiInfo.getBssid())) {
                    distance += Math.pow(inputWiFiInfo.getLevel() - positionWiFiInfo.getLevel(), 2);
                    count++;
                }
            }
        }
        if (count > 0) {
            distance = Math.sqrt(distance / count);
        } else {
            distance = Double.MAX_VALUE; // 没有匹配的 BSSID 时，距离设为最大值
        }
        return distance;
    }

    public void savePosition(Position position) {
        positionRepository.save(position);
    }


    public void savePrePosition(Integer userId,Position position) {
//        jedis.set(String.valueOf(userId), String.format("%f,%f,%f", position.getX(), position.getY(), position.getZ()));
        jedis.hset("elderly_positions", String.valueOf(userId), String.format("%f,%f,%f", position.getX(), position.getY(), position.getZ()));
    }

    public ElderlyPosition getElderlyPosition(Integer userId) {
        String positionStr = jedis.hget("elderly_positions", String.valueOf(userId));
        if (positionStr == null) {
            return null;
        }
        String[] posData = positionStr.split(",");
        double x = Double.parseDouble(posData[0]);
        double y = Double.parseDouble(posData[1]);
        double z = Double.parseDouble(posData[2]);
        return ElderlyPosition.builder().id(userId).x(x).y(y).z(z).build();
    }

    public List<ElderlyPosition> getAllElderlyPositions() {
        Map<String, String> allPositions = jedis.hgetAll("elderly_positions");
        List<ElderlyPosition> elderlyPositions = new ArrayList<>();
        for (Map.Entry<String, String> entry : allPositions.entrySet()) {
            String[] posData = entry.getValue().split(",");
            double x = Double.parseDouble(posData[0]);
            double y = Double.parseDouble(posData[1]);
            double z = Double.parseDouble(posData[2]);
            ElderlyPosition elderlyPosition = ElderlyPosition.builder().id(Integer.parseInt(entry.getKey())).x(x).y(y).z(z).build();
            elderlyPositions.add(elderlyPosition);
        }
        return elderlyPositions;
    }
}
