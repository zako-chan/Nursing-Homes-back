package com.example.ex3_2_back.controller;


import com.example.ex3_2_back.domain.wifiLocation.ElderlyPosition;
import com.example.ex3_2_back.domain.wifiLocation.LocationData;
import com.example.ex3_2_back.entity.Position;
import com.example.ex3_2_back.entity.WifiInfo;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.WifiLocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wifiLocation")
@AutoTakeCount
@Slf4j
@Tag(name = "wifi定位", description = "提供wifi定位相关接口")
public class WifiLocationController {

    private WifiLocationService wifiLocationService;
    @Autowired
    public void setWifiLocationService(WifiLocationService wifiLocationService) {
        this.wifiLocationService = wifiLocationService;
    }

    @PostMapping("/trainData")
    public String uploadTrainData(@RequestBody Position position) {
        wifiLocationService.savePosition(position);
        return "success";
    }

    @PostMapping("/predict")
    public void predictPosition(@RequestBody LocationData locationData) {
        Position position = wifiLocationService.predictPosition(locationData.getWifiInfos());
        wifiLocationService.savePrePosition(locationData.getId(), position);
    }

    @GetMapping("/positions")
    public List<ElderlyPosition> getAllPositions() {
        return wifiLocationService.getAllElderlyPositions();
    }
}
