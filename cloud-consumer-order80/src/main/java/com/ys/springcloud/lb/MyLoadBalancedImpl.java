package com.ys.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangsong
 * @date 2021/4/22 22:21
 */
@Component
public class MyLoadBalancedImpl implements MyLoadBalanced{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAtomicInteger() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    public final int getAtomicInteger(){
        // 访问次数
        int current;
        // 实际请求次数
        int next;
        do {
            // 取到当前访问的次数
            current = this.atomicInteger.get();
            // 访问次数 >= 100 从0开始重新计数，否则当前访问次数 +1
            next = current >= 100 ? 0 : current+1;
            // compareAndSet CAS比较并交换，比较访问次数和实际请求次数，如果比较成功，并且请求次数没有被其他服务的请求次数改变，则使用计算的出的实际请求次数
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*********第几次访问："+next);
        return next;
    }
}
