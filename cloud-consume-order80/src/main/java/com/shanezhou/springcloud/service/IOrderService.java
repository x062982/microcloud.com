package com.shanezhou.springcloud.service;

import com.shanezhou.springcloud.entity.CommonResult;
import com.shanezhou.springcloud.entity.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author shaneZhou
 * @Time 2020/06/13 18:10 下午
 */
@Service("orderService")
@FeignClient("CLOUD-PROVIDER-PAYMENT")
public interface IOrderService {

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payments")
    public CommonResult<List<Payment>> getPayments();

    @PostMapping("/payment")
    public CommonResult<Boolean> savePayment(@RequestBody Payment payment);

}
