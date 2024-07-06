package com.example.ex3_2_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiProjectApplication.class, args);
    }

}
