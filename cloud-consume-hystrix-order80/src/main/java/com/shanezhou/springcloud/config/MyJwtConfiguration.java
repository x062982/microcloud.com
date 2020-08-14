package com.shanezhou.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/13 星期四
 */
@Configuration
public class MyJwtConfiguration {

    @javax.annotation.Resource
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    @Qualifier("tokenStore")
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    public JwtAccessTokenConverter jwtTokenEnhance() {
        // 用jwt做转换器
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("public-key.cert");
        String publicKey = "";
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 设置公钥
        converter.setVerifierKey(publicKey);
        return converter;
    }

}
