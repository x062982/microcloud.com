package com.shanezhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ShaneZhou
 * @since 2020/9/22 周二
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication8902 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication8902.class, args);
    }
}
