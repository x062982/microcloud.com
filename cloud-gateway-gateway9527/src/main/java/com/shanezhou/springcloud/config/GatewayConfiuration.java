package com.shanezhou.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author shaneZhou
 * @Time 2020/07/18 17:46 下午
 */
@Configuration
public class GatewayConfiuration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_baiduguonei",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        routes.route("path_route_baidu",
                r -> r.path("/baidu")
                        .uri("https://www.baidu.com/")).build();
        return routes.build();
    }

}
