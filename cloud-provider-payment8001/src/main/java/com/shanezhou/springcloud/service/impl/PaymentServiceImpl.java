package com.shanezhou.springcloud.service.impl;

import com.shanezhou.springcloud.dao.IPaymentDao;
import com.shanezhou.springcloud.entity.Payment;
import com.shanezhou.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author shaneZhou
 * @Time 2020/06/06 15:34 下午
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private IPaymentDao dao;

    public int insert(Payment payment) {
        return dao.insert(payment);
    }

    public Payment getById(Long id) {
        return dao.getById(id);
    }
}
