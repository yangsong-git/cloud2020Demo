package com.ys.springcloud.controller;

import com.ys.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author yangsong
 * @date 2021/4/23 21:09
 */
@RestController
@RequestMapping("/payment/hystrix")
public class PaymentHystrixController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping(value = "/paymentInfo_ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_ok(id);
    }


    @GetMapping(value = "/paymentInfo_timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_timeout(id);
    }
}
