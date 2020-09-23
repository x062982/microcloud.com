package com.shanezhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/16 星期日
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class AuthServiceApplication8889 {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication8889.class, args);
    }
}
