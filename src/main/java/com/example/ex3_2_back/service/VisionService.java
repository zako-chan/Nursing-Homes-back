package com.example.ex3_2_back.service;


import com.example.ex3_2_back.grpc.server.vision.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VisionService {
    VisionServiceGrpc.VisionServiceBlockingStub visionServiceBlockingStub;
    @Autowired
    public void setVisionServiceBlockingStub(VisionServiceGrpc.VisionServiceBlockingStub visionServiceBlockingStub) {
        this.visionServiceBlockingStub = visionServiceBlockingStub;
    }

    public void faceCollection(Integer userId,String identity,String username,String pullUrl,String pushUrl){
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

    public void removeUrl(Integer userId,String identity,String username){
        RemoveUrlRequest request = RemoveUrlRequest.newBuilder()
                .setUserId(userId)
                .setIdentity(identity)
                .setUsername(username)
                .build();

        CommonResopnse response = visionServiceBlockingStub.removeUrl(request);

        log.info("response: {}", response);
    }

    public void startVisionService(Integer cameraId,String pullUrl,String pushUrl,Integer modelId){
        StartVisonServiceRequest request = StartVisonServiceRequest.newBuilder()
                .setCameraId(cameraId)
                .setPullUrl(pullUrl)
                .setPushUrl(pushUrl)
                .setModelId(modelId)
                .build();
        CommonResopnse response = visionServiceBlockingStub.startVisonService(request);

        log.info("response: {}", response);
    }
}
