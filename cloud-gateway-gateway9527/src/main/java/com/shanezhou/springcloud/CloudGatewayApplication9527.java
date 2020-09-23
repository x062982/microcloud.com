package com.shanezhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author shaneZhou
 * @Time 2020/07/18 11:11 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudGatewayApplication9527 {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication9527.class, args);
    }
}
