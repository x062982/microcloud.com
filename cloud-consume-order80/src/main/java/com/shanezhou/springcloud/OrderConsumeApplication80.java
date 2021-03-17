package com.shanezhou.springcloud;

import com.shanezhou.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author shaneZhou
 * @Time 2020/06/13 17:48 下午
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
//@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = MySelfRule.class)
public class OrderConsumeApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumeApplication80.class, args);
    }
}
