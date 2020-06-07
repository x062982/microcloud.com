package com.shanezhou.springcloud.controller;

import com.shanezhou.springcloud.entity.CommonResult;
import com.shanezhou.springcloud.entity.Payment;
import com.shanezhou.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author shaneZhou
 * @Time 2020/06/06 15:36 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult savePayment(Payment payment) {
        int result = paymentService.insert(payment);
        log.info("******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(500, "插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult gepPaymentById(@PathVariable(value = "id") Long id) {
        Payment result = paymentService.getById(id);
        log.info("******查询结果：" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功", result);
        } else {
            return new CommonResult(500, "没有对应记录，Id:" + id);
        }
    }

}
