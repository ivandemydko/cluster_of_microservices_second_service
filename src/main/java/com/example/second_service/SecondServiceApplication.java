package com.example.second_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EntityScan(basePackages = "model.secondmodel")
@EnableResourceServer
@EnableEurekaClient
public class SecondServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondServiceApplication.class, args);
    }

}
