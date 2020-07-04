package com.shanezhou.springcloud.controller;

import com.shanezhou.springcloud.entity.CommonResult;
import com.shanezhou.springcloud.entity.Payment;
import com.shanezhou.springcloud.lb.ILoadBalancer;
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
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Resource
    private ILoadBalancer loadBalancer;

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

    @GetMapping("/lb")
    public String getServiceLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        return instance.getHost();
    }
}
