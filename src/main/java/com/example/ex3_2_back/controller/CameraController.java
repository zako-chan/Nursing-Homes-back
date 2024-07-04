package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.camera.CameraCreateDomain;
import com.example.ex3_2_back.entity.Camera;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.CameraService;
import com.example.ex3_2_back.service.VisionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/camera")
@AutoTakeCount
@Tag(name = "摄像头管理",description = "管理摄像头信息")
public class CameraController {

    CameraService cameraService;
    @Autowired
    public void setCameraService(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    VisionService visionService;
    @Autowired
    public void setVisionService(VisionService visionService) {
        this.visionService = visionService;
    }

    @GetMapping
    @Operation(summary = "查询所有摄像头", description = "查询所有摄像头")
    public TResult<Page<Camera>> allCamera(@Schema(defaultValue = "0") @RequestParam int page,
                                           @Schema(defaultValue = "10") @RequestParam int pageSize){
        Page<Camera> cameras = cameraService.getAllCamera(PageRequest.of(page,pageSize));
        return TResult.success(cameras);
    }

    @PostMapping
    @Operation(summary = "添加摄像头", description = "添加摄像头")
    public TResult<Integer> addCamera(@RequestBody CameraCreateDomain cameraCreateDomain){
        Camera camera1 = cameraService.addCamera(cameraCreateDomain.getLocation());
        return TResult.success(camera1.getId());
    }

    @PostMapping("/start/{id}")
    @Operation(summary = "开启摄像头服务", description = "开启摄像头服务")
    public TResult startCamera(@Schema(description = "摄像头id") @PathVariable Integer id){
        boolean isActivate = cameraService.checkCamera("camera", id.toString());
        if(!isActivate) throw new RuntimeException("摄像头未推流至指定地址");
        cameraService.startCamera(id);
        return TResult.success();
    }

}
