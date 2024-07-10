package com.example.ex3_2_back.service;

import com.example.ex3_2_back.domain.wifiLocation.ElderlyPosition;
import com.example.ex3_2_back.entity.Position;
import com.example.ex3_2_back.entity.WifiInfo;
import com.example.ex3_2_back.repository.PositionRepository;
import com.example.ex3_2_back.repository.WifiInfoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
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

    private static final int K = 3;

    @Cacheable(value = "positions")
    public List<Position> getAllPositions() {
        List<Position> positions = positionRepository.findAllWithWifiInfos();
        return positions;
    }


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
        List<Position> positions = getAllPositions();

        // 计算每个位置与输入WIFI信息之间的距离
        Map<Position,Double> distanceMap = new HashMap<>();
        for(Position position:positions){

            double distance = calculateDistance(position,wifiInfoList);
            distanceMap.put(position,distance);
            if(position.getX()== 1 && position.getY()==2 && position.getZ()==1){
                log.info("position: {}", position);
                log.info("distance: {}", distance);
            }
        }

        // 找到距离最小的K个位置
        List<Map.Entry<Position, Double>> nearestNeighbors = distanceMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(K)
                .collect(Collectors.toList());
        Optional<Map.Entry<Position, Double>> zeroDistanceEntry = distanceMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 0)
                .findFirst();
        if(zeroDistanceEntry.isPresent()){
            return zeroDistanceEntry.get().getKey();
        }
        log.info("nearestNeighbors: {}", nearestNeighbors);
        // 计算加权平均值，作为预测位置
        double x = 0, y = 0, z = 0;
        double totalWeight = 0;
        for (Map.Entry<Position, Double> entry : nearestNeighbors) {
            double weight = 1 / entry.getValue(); // 距离越近，权重越大
            x += entry.getKey().getX() * weight;
            y += entry.getKey().getY() * weight;
            z += entry.getKey().getZ() * weight;
            totalWeight += weight;
        }
        x /= totalWeight;
        y /= totalWeight;
        z = Math.round(z / totalWeight);

//        for(Map.Entry<Position, Double> entry : nearestNeighbors){
//            x += entry.getKey().getX();
//            y += entry.getKey().getY();
//            z += entry.getKey().getZ();
//        }
//        x /= K;
//        y /= K;
//        z = Math.round(z/K);

        Position predictedPosition = new Position();
        predictedPosition.setX(x);
        predictedPosition.setY(y);
        predictedPosition.setZ(z);

        return predictedPosition;
    }

    /**
     * 计算两个位置之间的距离（欧氏距离）
     */
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

    /**
     * 计算两个位置之间的距离（bssid只取前x个leve）
     */
    private double calculateDistance(Position position, List<WifiInfo> inputWiFiInfos, int x) {
        Set<WifiInfo> positionWiFiInfos = position.getWifiInfos();
        PriorityQueue<WifiInfo> strongestWifiInfos = new PriorityQueue<>(Comparator.comparing(WifiInfo::getLevel).reversed());
        strongestWifiInfos.addAll(positionWiFiInfos);
        List<WifiInfo> topXWifiInfos = new ArrayList<>();
        int count = 0;
        while (count < x && !strongestWifiInfos.isEmpty()) {
            topXWifiInfos.add(strongestWifiInfos.poll());
            count++;
        }
        double distance = 0;
        count = 0;
        for (WifiInfo inputWiFiInfo : inputWiFiInfos) {
            for (WifiInfo positionWiFiInfo : topXWifiInfos) {
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

    /**
     * 计算位置时，只取欧氏距离前k小的
     */
    private double calculateTopDistance(Position position, List<WifiInfo> inputWiFiInfos, int x) {
        Set<WifiInfo> positionWiFiInfos = position.getWifiInfos();
        PriorityQueue<Double> distances = new PriorityQueue<>();
        for (WifiInfo inputWiFiInfo : inputWiFiInfos) {
            for (WifiInfo positionWiFiInfo : positionWiFiInfos) {
                if (inputWiFiInfo.getBssid().equals(positionWiFiInfo.getBssid())) {
                    double distance = Math.pow(inputWiFiInfo.getLevel() - positionWiFiInfo.getLevel(), 2);
                    distances.add(distance);
                }
            }
        }
        double totalDistance = 0;
        int count = 0;
        while (count < x && !distances.isEmpty()) {
            totalDistance += Math.sqrt(distances.poll());
            count++;
        }
        if (count > 0) {
            totalDistance /= count;
        } else {
            totalDistance = Double.MAX_VALUE; // 没有匹配的 BSSID 时，距离设为最大值
        }
        return totalDistance;
    }

    public double calculateStandardDistance(Position position, List<WifiInfo> inputWiFiInfos) {
        Set<WifiInfo> positionWiFiInfos = position.getWifiInfos();

        // 标准化positionWiFiInfos中的level
        Map<String, Double> standardizedPositionLevels = standardizeLevels(positionWiFiInfos);

        // 标准化inputWiFiInfos中的level
        Map<String, Double> standardizedInputLevels = standardizeLevels(inputWiFiInfos);

        double distance = 0;
        int count = 0;

        for (String bssid : standardizedInputLevels.keySet()) {
            if (standardizedPositionLevels.containsKey(bssid)) {
                double diff = standardizedInputLevels.get(bssid) - standardizedPositionLevels.get(bssid);
                distance += Math.pow(diff, 2);
                count++;
            }
        }

        if (count > 0) {
            distance = Math.sqrt(distance / count);
        } else {
            distance = Double.MAX_VALUE; // 没有匹配的 BSSID 时，距离设为最大值
        }

        return distance;
    }

    private Map<String, Double> standardizeLevels(Collection<WifiInfo> wifiInfos) {
        // 计算平均值和标准差
        List<Double> levels = wifiInfos.stream().map(WifiInfo::getLevel).collect(Collectors.toList());
        double mean = levels.stream().mapToDouble(val -> val).average().orElse(0.0);
        double std = Math.sqrt(levels.stream().mapToDouble(val -> Math.pow(val - mean, 2)).average().orElse(0.0));

        // 标准化
        Map<String, Double> standardizedLevels = new HashMap<>();
        for (WifiInfo wifiInfo : wifiInfos) {
            double standardizedValue = (wifiInfo.getLevel() - mean) / std;
            standardizedLevels.put(wifiInfo.getBssid(), standardizedValue);
        }

        return standardizedLevels;
    }


    @Transactional
    public void savePosition(Position position) {
        Position position1 = new Position();
        position1.setX(position.getX());
        position1.setY(position.getY());
        position1.setZ(position.getZ());
        position1 = positionRepository.save(position1);

        for (WifiInfo wifiInfo : position.getWifiInfos()) {
            wifiInfo.setPosition(position1);
            wifiInfoRepository.save(wifiInfo);
        }
    }


    public void savePrePosition(Integer userId,Position position) {
//        jedis.set(String.valueOf(userId), String.format("%f,%f,%f", position.getX(), position.getY(), position.getZ()));
        log.info("savePrePosition: userId={}, position={}", userId, position);
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
