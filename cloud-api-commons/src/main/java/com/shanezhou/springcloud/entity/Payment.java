package com.shanezhou.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单实体类
 * @Author ShaneZhou
 * @Time 2020/06/05 17:16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("PAYMENT")
@KeySequence(value = "SEQ_PAYMENT_ID", clazz = Long.class)
public class Payment implements Serializable {

    @TableId(type = IdType.INPUT)
    private Long id;

    private String serial;


}
