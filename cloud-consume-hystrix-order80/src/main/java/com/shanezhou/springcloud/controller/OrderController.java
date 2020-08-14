package com.shanezhou.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shanezhou.springcloud.entity.CommonResult;
import com.shanezhou.springcloud.entity.Payment;
import com.shanezhou.springcloud.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author shaneZhou
 * @Time 2020/06/14 19:02 下午
 */
@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        return orderService.getPaymentById(id);
    }

    @GetMapping("/payments")
    public CommonResult<List<Payment>> getPayments(){
        return orderService.getPayments();
    }

    @PostMapping("/payment")
    public CommonResult<Boolean> savePayment(@RequestBody Payment payment){
        return orderService.savePayment(payment);
    }

    @GetMapping("/consume/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        //int a = 1 / 0;
        return orderService.paymentInfo_Ok(id);
    }

    @GetMapping("/consume/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50000")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String s = orderService.paymentInfo_TimeOut(id);
        System.out.println(s);
        return s;
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id) {
        return "<h1>conusme Hystrix</h1>请等"+ id +"秒再试";
    }

    public String paymentGlobalFallbackMethod() {
        return "<h1>Consume Global Fallback</h1>";
    }

    @GetMapping("/outh")
    public String testOuth() {
        return "outh hello";
    }
}
