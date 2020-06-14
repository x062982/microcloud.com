package com.shanezhou.springcloud.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author shaneZhou
 * @Time 2020/06/13 18:14 下午
 */
@Configuration
public class MybatisPlusConfiguration {

    @Bean
    public IKeyGenerator keyGenerator() {
        return new OracleKeyGenerator();
    }

}
