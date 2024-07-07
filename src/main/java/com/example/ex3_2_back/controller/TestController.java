package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.grpc.server.message.GreeterGrpc;
import com.example.ex3_2_back.grpc.server.message.Model1RequestMessage;
import com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.websocket.WebSocket;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
@Hidden
@AutoTakeCount
public class TestController {
//    @Autowired
//    MessageServiceGrpc.EventServiceBlockingStub blockingStub;

    @Autowired
    GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    @Autowired
    WebSocket webSocket;

    @RequestMapping
    public String test() {
        // 创建请求
        Model1RequestMessage requestMessage = Model1RequestMessage.newBuilder()
                .setModelId("1")
                .build();
        // 发送请求
        Model1ResponseMessage responseMessage = greeterBlockingStub.model1Request(requestMessage);

        // 打印响应
        log.info("response: {}", responseMessage);
        return responseMessage.getCode();
    }

    @GetMapping("/websocket")
    public String testWebSocket() {
        WebSocket.sendMessage("test");
        return "success";
    }


}