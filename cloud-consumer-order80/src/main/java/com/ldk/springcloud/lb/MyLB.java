package com.ldk.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @class: MyLB
 * @author:
 * @date: 2020/11/21 15:44
 * @description: 自定义轮训算法
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance  instances(List<ServiceInstance> serviceInstances) {
        int i = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(i);
    }
}
