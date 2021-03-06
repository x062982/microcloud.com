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
public class CommonResult<T> {

    private Integer code;
    private String message;

    private T data;

    public CommonResult () {
        this.code = 0;
    }

    public CommonResult (Integer code, String message) {
        this(code, message, null);
    }
}
