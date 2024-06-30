package com.example.ex3_2_back.grpc.server;

import com.example.ex3_2_back.entity.EventInfo;
import com.example.ex3_2_back.entity.Elderly;
import com.example.ex3_2_back.repository.ElderlyRepository;
import com.example.ex3_2_back.repository.EventInfoRepository;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@GrpcService
@Slf4j
//@Service
public class EventServiceImpl extends EventServiceGrpc.EventServiceImplBase {

    @Autowired
    private EventInfoRepository eventInfoRepository;

    @Autowired
    private ElderlyRepository elderlyRepository;

    @Override
    public void createEvent(EventRequest request, StreamObserver<EventServerResopnse> responseObserver) {
        try {
            log.info("createEvent: " + request);
            Elderly elderly = elderlyRepository.findById(request.getElderlyId())
                    .orElseThrow(() -> new RuntimeException("Elderly not found with id " + request.getElderlyId()));
//            Elderly elderly = new Elderly();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date eventDate = sdf.parse(request.getEventDate());

            EventInfo eventInfo = new EventInfo(
                    request.getEventType(),
                    eventDate,
                    request.getEventLocation(),
                    request.getEventDescription(),
                    elderly
            );
            log.info("Event created: " + eventInfo);
            eventInfoRepository.save(eventInfo);

            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Event created successfully")
                    .setCode(200)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            EventServerResopnse response = EventServerResopnse.newBuilder()
                    .setMessage("Error occurred: " + e.getMessage())
                    .setCode(500)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}