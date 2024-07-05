package com.example.ex3_2_back.service;


import com.example.ex3_2_back.domain.camera.StreamResponse;
import com.example.ex3_2_back.entity.Camera;
import com.example.ex3_2_back.repository.CameraRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CameraService {

    @Value("${camera.base-push-url}")
    String basePushUrl;

    @Value("${camera.base-pull-url}")
    String basePullUrl;

    @Value("${camera.stream-url}")
    String streamUrl;

    RestTemplate restTemplate;
    public void setRestTemplate (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    CameraRepository cameraRepository;
    @Autowired
    public void setCameraRepository(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

//    VisionService visionService;
//    @Autowired
//    public void setVisionService(VisionService visionService) {
//        this.visionService = visionService;
//    }

    public Camera addCamera(String location){
        Camera camera = cameraRepository.save(Camera.builder().location(location).build());
        camera.setRtmpUrl(basePushUrl + "/camera/" +camera.getId());
        camera.setProcessUrl(basePullUrl +"/process/"+ camera.getId() + ".flv");
        camera.setOriginalUrl(basePullUrl + "/camera/"+camera.getId() + ".flv");
        cameraRepository.save(camera);
        return camera;
    }

    public Page<Camera> getAllCamera(Pageable pageable){
        return cameraRepository.findByRemoveIsFalse(pageable);
    }

    public boolean startCamera(Integer id){
        Camera camera = cameraRepository.findById(id).orElse(null);
        if(camera == null) throw new RuntimeException("摄像头"+id+"不存在");
        camera.setActive(true);
        cameraRepository.save(camera);
        return true;
    }

    public boolean checkCamera(String app, String cameraId){
        ResponseEntity<StreamResponse> response = restTemplate.getForEntity(streamUrl, StreamResponse.class);
        if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null){
            for(StreamResponse.Stream stream : response.getBody().getStreams()){
                if(StringUtils.equals(stream.getApp(), app) && StringUtils.equals(stream.getId(), cameraId)){
                    return true;
                }
            }
        }
        return true;
    }

    public Optional<Camera> getCameraById(Integer id){
        return cameraRepository.findById(id);
    }
}
