package com.shanezhou.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

/**
 * @Author shaneZhou
 * @Time 2020/07/04 14:48 下午
 */
@Service("service")
public class PaymentService {

    public String paymentInfo_Ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\t paymentInfo_Ok,id：" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        //try {
        //    TimeUnit.SECONDS.sleep(id);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        return "线程池：" + Thread.currentThread().getName() + "\t  paymentInfo_TimeOut,id：" + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "<h1>Hystrix</h1>线程池：" + Thread.currentThread().getName() + "\t  paymentInfo_TimeOutHandler,id：" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakFallback", commandProperties = {
            // 打开断路器，在10秒内请求失败率达到60%，即10次有6次失败就跳闸
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),   // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),   // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreak(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id can not be negative!");
        }
        int serialNumber = new Random().nextInt();
        return Thread.currentThread().getName() + "\t   serialNumber:" + serialNumber;
    }

    public String paymentCircuitBreakFallback(@PathVariable("id") Integer id) {
        return "<h1>id can not be negative! please try again later</h1>";
    }
}