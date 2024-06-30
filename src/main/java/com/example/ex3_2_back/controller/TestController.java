package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.grpc.server.EventRequest;
import com.example.ex3_2_back.grpc.server.EventServerResopnse;
import com.example.ex3_2_back.grpc.server.EventServiceGrpc;
import com.example.ex3_2_back.log.AutoTakeCount;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
@Hidden
@AutoTakeCount
public class TestController {
    @Autowired
    EventServiceGrpc.EventServiceBlockingStub blockingStub;

    @RequestMapping
    public String test() {
        // 创建请求
        EventRequest request = EventRequest.newBuilder()
                .setElderlyId(1)
                .setEventType(0)
                .setEventDate("2021-08-01 12:00:00")
                .setEventLocation("home")
                .setEventDescription("fall down")
                .build();

        // 发送请求
        EventServerResopnse response = blockingStub.createEvent(request);

        // 打印响应
        log.info(response.getMessage());
        return response.getMessage();
    }
}