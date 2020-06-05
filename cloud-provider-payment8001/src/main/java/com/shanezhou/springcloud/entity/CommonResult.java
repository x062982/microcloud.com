package com.shanezhou.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ShaneZhou
 * @Time 2020/06/05 17:21:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private String code;
    private String message;

    private T data;

    public CommonResult (String code, String message) {
        this(code, message, null);
    }
}
