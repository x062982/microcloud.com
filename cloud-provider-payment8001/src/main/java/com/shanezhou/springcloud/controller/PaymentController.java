package com.shanezhou.springcloud.controller;

import com.shanezhou.springcloud.entity.CommonResult;
import com.shanezhou.springcloud.entity.Payment;
import com.shanezhou.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author shaneZhou
 * @Time 2020/06/06 15:36 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment")
    public CommonResult<Boolean> savePayment(@RequestBody Payment payment) {
        boolean result = paymentService.save(payment);
        log.info("******插入结果：" + result);
        if (result) {
            return new CommonResult<>(200, "插入数据库成功", result);
        } else {
            return new CommonResult<>(500, "插入数据库失败");
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> gepPaymentById(@PathVariable(value = "id") Long id) {
        Payment result = paymentService.getById(id);
        log.info("******查询结果：" + result);
        if (result != null) {
            return new CommonResult<>(200, "查询成功", result);
        } else {
            return new CommonResult<>(500, "没有对应记录，Id:" + id);
        }
    }

    @GetMapping("/payments")
    public CommonResult<List<Payment>> gepPayments() {
        List<Payment> result = paymentService.list();

        log.info("******查询结果：" + result);
        if (result != null) {
            return new CommonResult<>(200, serverPort + "查询成功", result);
        } else {
            return new CommonResult<>(500, serverPort + "没有记录", null);
        }
    }

    @GetMapping("/lb")
    public String getServerPort() {
        return serverPort;
    }
}
