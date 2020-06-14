package com.shanezhou.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanezhou.springcloud.dao.PaymentMapper;
import com.shanezhou.springcloud.entity.Payment;
import com.shanezhou.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

/**
 * @Author shaneZhou
 * @Time 2020/06/06 15:34 下午
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {


}
