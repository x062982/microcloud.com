package com.shanezhou.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ShaneZhou
 * @since 2020/9/25 周五
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main").setViewName("dashboard");
        registry.addViewController("/login").setViewName("index");

    }

    /**
     * 国际化语言
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new LocaleResolverConfiguration();
    }

    /**
     * 注册拦截器
     * @param registry
     */
    //@Override
    //public void addInterceptors(InterceptorRegistry registry) {
    //    //super.addInterceptors(registry);
    //    registry.addInterceptor(new LoginHandlerIntercepter())
    //            .addPathPatterns("/**")
    //            .excludePathPatterns("/", "/index", "/user/login", "/index.html", "/webjars/**", "/assets/**")
    //            .excludePathPatterns("/hello/**", "/testpoi.html");
    //}

}
