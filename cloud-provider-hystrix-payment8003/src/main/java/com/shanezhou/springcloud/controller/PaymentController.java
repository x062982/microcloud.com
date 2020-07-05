package com.shanezhou.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shanezhou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @Author shaneZhou
 * @Time 2020/06/06 15:36 下午
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class PaymentController {

    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    @HystrixCommand
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        //int a = 1 / 0;
        return service.paymentInfo_Ok(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        System.out.println(id);
        return service.paymentInfo_TimeOut(id);
    }

    @GetMapping("/hystrix/circuit/{id}")
    public String paymentInfo_circuit(@PathVariable("id") Integer id) {
        return service.paymentCircuitBreak(id);
    }

    public String paymentGlobalFallbackMethod() {
        return "<h1>Global Fallback</h1>";
    }
}
