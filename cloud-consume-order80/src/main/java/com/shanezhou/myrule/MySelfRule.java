package com.shanezhou.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author shaneZhou
 * @Time 2020/06/20 14:36 下午
 */
@Configuration
public class MySelfRule  {

    /**
     * 选择负载均衡策略
     * @return
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
