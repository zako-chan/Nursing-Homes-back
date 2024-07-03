package com.example.ex3_2_back.configuration;

//import com.example.ex3_2_back.grpc.server.EventServiceGrpc;
import com.example.ex3_2_back.grpc.server.message.GreeterGrpc;
import com.example.ex3_2_back.grpc.server.vision.VisionService;
import com.example.ex3_2_back.grpc.server.vision.VisionServiceGrpc;
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
     * message服务地址
     */
    @Value("${client.message-service.address}")
    private String messageServiceAddress;

    /**
     * vision服务地址
     */
    @Value("${client.vision-service.address}")
    private String visionServiceAddress;

    /**
     * 事件服务grpc-client
     */
//    @Bean
//    public EventServiceGrpc.EventServiceBlockingStub eventServiceBlockingStub() {
//        return EventServiceGrpc.newBlockingStub(ManagedChannelBuilder.forTarget(eventServiceAddress).usePlaintext().build());
//    }

    /**
     * message服务grpc-client
     */
    @Bean
    public GreeterGrpc.GreeterBlockingStub greeterBlockingStub() {
        return GreeterGrpc.newBlockingStub(ManagedChannelBuilder.forTarget(messageServiceAddress).usePlaintext().build());
    }

    @Bean
    public VisionServiceGrpc.VisionServiceBlockingStub visionServiceBlockingStub() {
        return VisionServiceGrpc.newBlockingStub(ManagedChannelBuilder.forTarget(visionServiceAddress).usePlaintext().build());
    }
}
