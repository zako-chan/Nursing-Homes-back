package com.example.ex3_2_back.grpc.server.event;


import com.example.ex3_2_back.entity.Elderly;
import com.example.ex3_2_back.entity.EventInfo;
import com.example.ex3_2_back.repository.EventInfoRepository;
import com.example.ex3_2_back.websocket.WebSocket;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

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

    @Override
    public void emotionDetectionEvent(EmotionDetectionEventRequest request,
                                      StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("emotionDetectionEvent: " + request);
//            EventInfo eventInfo = new EventInfo();
//            eventInfo.setEventType(0);
//            eventInfo.setEventDesc("检测到老人情绪");
//            eventInfo.setEventImgUrl(request.getImageUrl());
//            Elderly elderly = new Elderly();
//            elderly.setId(request.getElderlyId());
//            eventInfo.setElderly(elderly);
//
//            eventInfoRepository.save(eventInfo);
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
    public void faceRecognitionEvent(FaceRecognitionEventRequest request,
                                     StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("faceRecognitionEvent: " + request);
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

    //TODO：代更改-增加义工信息
    @Override
    public void volunteerInteractionEvent(VolunteerInteractionEventRequest request,
                                          StreamObserver<EventServerResopnse> responseObserver) {
        try{
            log.info("volunteerInteractionEvent: " + request);
//            EventInfo eventInfo = new EventInfo();
//            eventInfo.setEventType(1);
//            eventInfo.setEventDesc("检测到义工与老人交互");
//            eventInfo.setEventImgUrl(request.getImageUrl());
//            Elderly elderly = new Elderly();
//            elderly.setId(request.getElderlyId());
//            eventInfo.setElderly(elderly);
//
//            eventInfoRepository.save(eventInfo);
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
//            EventInfo eventInfo = new EventInfo();
//            eventInfo.setEventType(2);
//            eventInfo.setEventDesc("检测到陌生人");
//            eventInfo.setEventImgUrl(request.getImageUrl());
//
//            eventInfoRepository.save(eventInfo);
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
//            EventInfo eventInfo = new EventInfo();
//            eventInfo.setEventType(3);
//            eventInfo.setEventDesc("检测到有老人摔跤");
//            eventInfo.setEventImgUrl(request.getImageUrl());
//
//            eventInfo = eventInfoRepository.save(eventInfo);
//
//            // 通知管理员
//            webSocket.sendMessage("有老人摔倒，请及时处理，详情见事件"+eventInfo.getId()+"查看");


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
//            EventInfo eventInfo = new EventInfo();
//            eventInfo.setEventType(4);
//            eventInfo.setEventDesc("检测到老人情绪");
//            eventInfo.setEventImgUrl(request.getImageUrl());

//            eventInfoRepository.save(eventInfo);
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
