package com.shanezhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author shaneZhou
 * @Time 2020/08/13 19:01 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class AuthServiceApplication8888 {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication8888.class, args);
    }
}
