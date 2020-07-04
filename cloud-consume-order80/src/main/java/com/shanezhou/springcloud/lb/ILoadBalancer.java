package com.shanezhou.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author shaneZhou
 * @Time 2020/06/20 14:48 下午
 */
public interface ILoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
