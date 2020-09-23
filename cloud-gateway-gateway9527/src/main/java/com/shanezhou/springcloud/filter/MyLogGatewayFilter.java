//package com.shanezhou.springcloud.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @Author shaneZhou
// * @Time 2020/07/20 18:52 下午
// */
//@Component
//@Slf4j
//public class MyLogGatewayFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("******Come in MyLogGatewayFilter******");
//        //String username = exchange.getRequest().getQueryParams().getFirst("username");
//        //if (username == null) {
//        //    log.error("******用户名为空，没有权限！");
//        //    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//        //    return exchange.getResponse().setComplete();
//        //}
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
