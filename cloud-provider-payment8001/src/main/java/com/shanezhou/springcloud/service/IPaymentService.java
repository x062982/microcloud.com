package com.shanezhou.springcloud.service;

import com.shanezhou.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author shaneZhou
 * @Time 2020/06/06 15:32 下午
 */
public interface IPaymentService {

    int insert(Payment payment);

    Payment getById(@Param("id") Long id);
}
