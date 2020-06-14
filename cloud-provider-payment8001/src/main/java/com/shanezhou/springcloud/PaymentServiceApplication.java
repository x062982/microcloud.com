package com.shanezhou.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ShaneZhou
 * @Time 2020/06/05 17:01:10
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.shanezhou.springcloud.dao")
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
