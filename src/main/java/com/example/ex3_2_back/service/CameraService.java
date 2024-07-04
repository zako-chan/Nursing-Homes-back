package com.example.ex3_2_back.service;


import com.example.ex3_2_back.entity.Camera;
import com.example.ex3_2_back.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CameraService {

    @Value("${camera.base-push-url}")
    String basePushUrl;

    @Value("${camera.base-pull-url}")
    String basePullUrl;

    CameraRepository cameraRepository;
    @Autowired
    public void setCameraRepository(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    public Camera addCamera(String location){
        Camera camera = cameraRepository.save(Camera.builder().location(location).build());
        camera.setRtmpUrl(basePushUrl + "/camera/" +camera.getId());
        camera.setProcessUrl(basePullUrl +"/process/"+ camera.getId() + ".flv");
        camera.setOriginalUrl(basePushUrl + "/camera/"+camera.getId() + ".flv");
        cameraRepository.save(camera);
        return camera;
    }

    public Page<Camera> getAllCamera(Pageable pageable){
        return cameraRepository.findByRemoveIsFalse(pageable);
    }

    public boolean startCamera(Integer id){
        return true;
    }
}
