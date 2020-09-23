package com.shanezhou.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/16 星期日
 */
@EnableWebFluxSecurity
public class ResourceServiceConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity.authorizeExchange()
                .pathMatchers("/actuator/**").permitAll()
                .pathMatchers("/cloud-gateway/actuator/**").permitAll()
                .pathMatchers("/auth-service/actuator/**").permitAll()
                .pathMatchers("/auth-service/**").permitAll()
                .pathMatchers("/oauth/**").permitAll()
                .anyExchange().authenticated().and().csrf().disable();

        serverHttpSecurity.oauth2ResourceServer().jwt();

        return serverHttpSecurity.build();
    }
}
