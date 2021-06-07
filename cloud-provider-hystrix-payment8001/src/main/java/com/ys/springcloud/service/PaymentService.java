package com.ys.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yangsong
 * @date 2021/4/23 21:00
 */
@Service

public class PaymentService {
    public String paymentInfo_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_ok,id:   "+id+"    😄";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" , value = "10000")})
    public String paymentInfo_timeout(Integer id){
        int timeNumber = id;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int age = 10/0;
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_timeout,id:   "+id+"    😄  耗时"+id+"秒";
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   系统繁忙，请稍后";
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" ,value = "60") //失败率达到多少后跳闸
    })
     public String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("参数不能为负数id："+id);
        }
        String number = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"   调用成功，流水号："+number;
     }

     public String paymentCircuitBreakerFallBack(Integer id){
        return "参数错误："+id;
     }
}
