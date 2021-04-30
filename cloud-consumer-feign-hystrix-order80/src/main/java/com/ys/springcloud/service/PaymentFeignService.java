package com.ys.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yangsong
 * @date 2021/4/23 22:39
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/hystrix/paymentInfo_ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id);


    @GetMapping(value = "/payment/hystrix/paymentInfo_timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id);
}
