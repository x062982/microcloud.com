package com.shanezhou.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShaneZhou
 * @since 2020/9/22 周二
 */
@RestController
public class ConfigClient2Controller {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/info2")
    public String getConfigInfo() {
        return configInfo;
    }
}
