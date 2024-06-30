package com.example.ex3_2_back.configuration;

import com.example.ex3_2_back.grpc.server.EventServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @apiNote 配置 gRPC 客户端
 */
@Configuration
public class GrpcClientConfig {

    /**
     * 事件服务地址
     */
    @Value("${grpc.client.event-service.address}")
    private String eventServiceAddress;

    /**
     * 事件服务grpc-client
     */
    @Bean
    public EventServiceGrpc.EventServiceBlockingStub eventServiceBlockingStub() {
        return EventServiceGrpc.newBlockingStub(ManagedChannelBuilder.forTarget(eventServiceAddress).usePlaintext().build());
    }
}
