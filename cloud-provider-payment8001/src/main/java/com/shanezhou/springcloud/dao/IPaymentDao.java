package com.shanezhou.springcloud.dao;

import com.shanezhou.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ShaneZhou
 * @Time 2020/06/05 17:24:30
 */
@Mapper
public interface IPaymentDao {

    boolean insert(Payment payment);

    Payment getById(@Param("id") Long id);
}
