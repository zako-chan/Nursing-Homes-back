package com.example.ex3_2_back.service;


import com.example.ex3_2_back.entity.Camera;
import com.example.ex3_2_back.grpc.server.vision.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VisionService {

    @Value("${camera.base-push-url}")
    String basePushUrl;

    @Value("${camera.base-pull-url}")
    String basePullUrl;


    VisionServiceGrpc.VisionServiceBlockingStub visionServiceBlockingStub;
    @Autowired
    public void setVisionServiceBlockingStub(VisionServiceGrpc.VisionServiceBlockingStub visionServiceBlockingStub) {
        this.visionServiceBlockingStub = visionServiceBlockingStub;
    }

    /**
     * 人脸库中添加人脸
     */
    public void faceCollection(Integer userId,String identity,String username){
        String pullUrl = basePullUrl + "/face/" + identity + userId + ".flv";
        String pushUrl = basePushUrl + "/faceprocess/" + identity + userId;
        FaceCollectionRequest request = FaceCollectionRequest.newBuilder()
                .setUserId(userId)
                .setIdentity(identity)
                .setUsername(username)
                .setPullUrl(pullUrl)
                .setPushUrl(pushUrl)
                .build();
        
        CommonResopnse response = visionServiceBlockingStub.faceCollection(request);

        log.info("response: {}", response);
    }

    /**
     * 删除人脸库中的人脸
     */
    public void removeUrl(Integer userId,String identity,String username){
        RemoveUrlRequest request = RemoveUrlRequest.newBuilder()
                .setUserId(userId)
                .setIdentity(identity)
                .setUsername(username)
                .build();

        CommonResopnse response = visionServiceBlockingStub.removeUrl(request);

        log.info("response: {}", response);
    }

    /**
     * 开启计算机视觉端的服务
     */
    public void startVisionService(Camera camera){
        String pushUrl = basePushUrl + "/process/" + camera.getId();
        StartVisonServiceRequest request = StartVisonServiceRequest.newBuilder()
                .setCameraId(camera.getId())
                .setPullUrl(camera.getOriginalUrl())
                .setPushUrl(pushUrl)
                .setModelId(camera.getService())
                .build();
        CommonResopnse response = visionServiceBlockingStub.startVisonService(request);

        log.info("response: {}", response);
    }

}
