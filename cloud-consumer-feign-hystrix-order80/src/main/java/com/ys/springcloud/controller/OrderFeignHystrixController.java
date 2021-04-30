package com.ys.springcloud.controller;

import com.ys.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangsong
 * @date 2021/4/23 22:42
 */
@RestController
@RequestMapping("consumer")
public class OrderFeignHystrixController {
    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping(value = "/paymentInfo_ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_ok(id);
    }


    @GetMapping(value = "/paymentInfo_timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_timeout(id);
    }
}
