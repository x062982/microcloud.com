package com.shanezhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloudServerConfig8903Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudServerConfig8903Application.class, args);
    }

}
