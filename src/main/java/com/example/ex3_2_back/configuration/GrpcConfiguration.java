package com.example.ex3_2_back.configuration;

import com.example.ex3_2_back.grpc.server.EventServiceImpl;
import com.example.ex3_2_back.grpc.server.message.GreeterServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Server server = ServerBuilder.forPort(9380)
                    .addService(new GreeterServiceImpl())
                    .build();

            // Start the server in a new thread so it doesn't block
            new Thread(() -> {
                try {
                    server.start();
                    server.awaitTermination();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        };
    }
}