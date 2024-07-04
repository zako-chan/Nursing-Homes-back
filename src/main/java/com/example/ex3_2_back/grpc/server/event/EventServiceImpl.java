package com.example.ex3_2_back.grpc.server.event;


import com.example.ex3_2_back.entity.*;
import com.example.ex3_2_back.exception.ResourceAlreadyExistsException;
import com.example.ex3_2_back.exception.ResourceNotExistException;
import com.example.ex3_2_back.repository.ElderlyRepository;
import com.example.ex3_2_back.repository.EmployeeRepository;
import com.example.ex3_2_back.repository.EventInfoRepository;
import com.example.ex3_2_back.repository.VolunteerRepository;
import com.example.ex3_2_back.utils.IdentityConstant;
import com.example.ex3_2_back.websocket.WebSocket;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * 提供给计算机视觉端调用的函数
 */
@GrpcService
@Slf4j
public class EventServiceImpl extends EventServiceGrpc.EventServiceImplBase{

    WebSocket webSocket;
    @Autowired
    public void setWebSocket(WebSocket webSocket) {
        this.webSocket = webSocket;
    }

    EventInfoRepository eventInfoRepository;
    @Autowired
    public void setEventInfoRepository(EventInfoRepository eventInfoRepository) {
        this.eventInfoRepository = eventInfoRepository;
    }

    ElderlyRepository elderlyRepository;
    @Autowired
    public void setElderlyRepository(ElderlyRepository elderlyRepository) {
        this.elderlyRepository = elderlyRepository;
    }

    EmployeeRepository employeeRepository;
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    VolunteerRepository volunteerRepository;
    @Autowired
    public void setVolunteerRepository(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public void emotionDetectionEvent(EmotionDetectionEventRequest request,
                                      StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("emotionDetectionEvent: " + request);
            EventInfo eventInfo = EventInfo.builder()
                    .eventType(0)
                    .eventDesc("检测到老人情绪")
                    .eventImgUrl(request.getImageUrl())
                    .camera(Camera.builder().id(request.getCameraId()).build())
                    .elderly(Elderly.builder().id(request.getElderlyId()).build())
                    .build();

            eventInfoRepository.save(eventInfo);
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Event created successfully")
                    .setCode(200)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Error occurred: " + e.getMessage())
                    .setCode(500)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    private void updateProfile(String identity,Integer userId,String url) {
        if (IdentityConstant.ELDERLY.equals(identity)){
            Optional<Elderly> elderlyOptional = elderlyRepository.findById(userId);
            if(elderlyOptional.isEmpty()) throw new ResourceAlreadyExistsException(identity + "中" + userId + "不存在");
            Elderly elderly = elderlyOptional.get();
            elderly.setProfilePhoto(url);
            elderlyRepository.save(elderly);
        }
        if (IdentityConstant.EMPLOYEE.equals(identity)) {
            Optional<Employee> employeeOptional = employeeRepository.findById(userId);
            if(employeeOptional.isEmpty()) throw new ResourceAlreadyExistsException(identity + "中" + userId + "不存在");
            Employee employee = employeeOptional.get();
            employee.setProfilePhoto(url);
            employeeRepository.save(employee);
        }
        if(IdentityConstant.VOLUNTEER.equals(identity)) {
            Optional<Volunteer> volunteerOptional = volunteerRepository.findById(userId);
            if(volunteerOptional.isEmpty()) throw new ResourceAlreadyExistsException(identity + "中" + userId + "不存在");
            Volunteer volunteer = volunteerOptional.get();
            volunteer.setProfilePhoto(url);
            volunteerRepository.save(volunteer);
        }
    }


    private void entranceGuard(String identity,Integer userId,Integer type,EventInfo eventInfo){
        if (IdentityConstant.ELDERLY.equals(identity)){
            Optional<Elderly> elderlyOptional = elderlyRepository.findById(userId);
            if(elderlyOptional.isEmpty()) throw new ResourceAlreadyExistsException(identity + "中" + userId + "不存在");
            Elderly elderly = elderlyOptional.get();
            eventInfo.setElderly(elderly);
        }
        if (IdentityConstant.EMPLOYEE.equals(identity)) {
            Optional<Employee> employeeOptional = employeeRepository.findById(userId);
            if(employeeOptional.isEmpty()) throw new ResourceAlreadyExistsException(identity + "中" + userId + "不存在");
            Employee employee = employeeOptional.get();
            eventInfo.setEmployee(employee);
        }
        if(IdentityConstant.VOLUNTEER.equals(identity)) {
            Optional<Volunteer> volunteerOptional = volunteerRepository.findById(userId);
            if(volunteerOptional.isEmpty()) throw new ResourceAlreadyExistsException(identity + "中" + userId + "不存在");
            Volunteer volunteer = volunteerOptional.get();
            eventInfo.setVolunteer(volunteer);
        }
        eventInfo.setEventDesc("检测到"+identity+userId + (type==0?"进入":"离开") + "养老院");
        eventInfoRepository.save(eventInfo);
    }

    @Override
    public void faceRecognitionEvent(FaceRecognitionEventRequest request,
                                     StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("faceRecognitionEvent: " + request);
            EventInfo eventInfo = EventInfo.builder()
                    .eventType(5)
                    .eventImgUrl(request.getImageUrl())
                    .camera(Camera.builder().id(request.getCameraId()).build())
                    .build();
            entranceGuard(request.getIdentity(),request.getUserId(),request.getType(),eventInfo);
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Event created successfully")
                    .setCode(200)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Error occurred: " + e.getMessage())
                    .setCode(500)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void volunteerInteractionEvent(VolunteerInteractionEventRequest request,
                                          StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("volunteerInteractionEvent: " + request);
            EventInfo eventInfo = EventInfo.builder()
                    .eventType(1)
                    .eventDesc("检测到义工与老人交互")
                    .eventImgUrl(request.getImageUrl())
                    .elderly(Elderly.builder().id(request.getElderlyId()).build())
                    .camera(Camera.builder().id(request.getCameraId()).build())
                    .volunteer(Volunteer.builder().id(request.getVolunteerId()).build())
                    .build();

            eventInfoRepository.save(eventInfo);
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Event created successfully")
                    .setCode(200)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Error occurred: " + e.getMessage())
                    .setCode(500)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void strangerDetectionEvent(StrangerDetectionEventRequest request,
                                       StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("strangerDetectionEvent: " + request);
            EventInfo eventInfo = EventInfo.builder()
                    .eventType(2)
                    .eventDesc("检测到陌生人")
                    .eventImgUrl(request.getImageUrl())
                    .camera(Camera.builder().id(request.getCameraId()).build())
                    .build();
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Event created successfully")
                    .setCode(200)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            log.info("strangerDetectionEvent: " + e.getMessage());
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Error occurred: " + e.getMessage())
                    .setCode(500)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

    }

    /**
     * 老人摔倒，通知管理员
     */
    @Override
    public void fallDetectionEvent(FallDetectionEventRequest request,
                                   StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("fallDetectionEvent: " + request);
            EventInfo eventInfo = EventInfo.builder()
                    .eventType(3)
                    .eventDesc("检测到老人摔倒")
                    .eventImgUrl(request.getImageUrl())
                    .elderly(Elderly.builder().id(request.getElderlyId()).build())
                    .camera(Camera.builder().id(request.getCameraId()).build())
                    .build();


            eventInfo = eventInfoRepository.save(eventInfo);

            // 通知管理员
            webSocket.sendMessage("有老人摔倒，请及时处理，详情见事件"+eventInfo.getId()+"查看");


            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Event created successfully")
                    .setCode(200)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }catch(Exception e){
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Error occurred: " + e.getMessage())
                    .setCode(500)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void forbiddenAreaInvasionDetectionEvent(ForbiddenAreaInvasionDetectionEventRequest request,
                                                    StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("forbiddenAreaInvasionDetectionEvent: " + request);
            EventInfo eventInfo = EventInfo.builder()
                    .eventType(1)
                    .eventDesc("检测到禁区有人闯入")
                    .eventImgUrl(request.getImageUrl())
                    .camera(Camera.builder().id(request.getCameraId()).build())
                    .build();
            eventInfoRepository.save(eventInfo);
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Event created successfully")
                    .setCode(200)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Error occurred: " + e.getMessage())
                    .setCode(500)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

    }

    @Override
    public void updateImageUrl(UpdateImageUrlRequest request,
                               StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("updateImageUrl: " + request);
            updateProfile(request.getIdentity(),request.getUserId(),request.getImageUrl());
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Event created successfully")
                    .setCode(200)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Error occurred: " + e.getMessage())
                    .setCode(500)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
