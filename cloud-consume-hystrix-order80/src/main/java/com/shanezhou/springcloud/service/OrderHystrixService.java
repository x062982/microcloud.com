package com.shanezhou.springcloud.service;

import com.shanezhou.springcloud.entity.CommonResult;
import com.shanezhou.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author shaneZhou
 * @Time 2020/07/05 15:40 下午
 */
@Component
public class OrderHystrixService implements IOrderService {

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return null;
    }

    @Override
    public CommonResult<List<Payment>> getPayments() {
        return null;
    }

    @Override
    public CommonResult<Boolean> savePayment(Payment payment) {
        return null;
    }

    @Override
    public String paymentInfo_Ok(Integer id) {
        return "OK's Fallback";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "Timeout's Fallback";
    }
}
