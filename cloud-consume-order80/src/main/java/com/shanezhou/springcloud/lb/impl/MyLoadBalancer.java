package com.shanezhou.springcloud.lb.impl;

import com.shanezhou.springcloud.lb.ILoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author shaneZhou
 * @Time 2020/06/20 14:50 下午
 */
@Component
public class MyLoadBalancer implements ILoadBalancer {

    private AtomicInteger index = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.index.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.index.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
