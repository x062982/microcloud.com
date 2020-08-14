package com.shanezhou.springcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 开启 方法级别 的 安全验证。
 * @Author ZhouWX
 * @CreateDate 2020/8/13 星期四
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class GlobalMethodSecurityConfiguration {
}
