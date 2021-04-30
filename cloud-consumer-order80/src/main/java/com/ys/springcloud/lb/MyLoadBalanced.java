package com.ys.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalanced {
    /**
     * 负载均衡轮询算法方法
     * @author   yangsong
     * @date     2021/4/22 21:53
     * @param serviceInstances:
     * @return: org.springframework.cloud.client.ServiceInstance
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
