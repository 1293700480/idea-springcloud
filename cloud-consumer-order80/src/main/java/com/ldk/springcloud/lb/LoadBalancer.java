package com.ldk.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @class: LoadBalancer
 * @author:
 * @date: 2020/11/21 15:40
 * @description: loadbanlancer
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
