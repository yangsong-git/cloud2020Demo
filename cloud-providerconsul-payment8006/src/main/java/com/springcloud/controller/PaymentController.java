package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author yangsong
 * @date 2021/4/19 19:42
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/consul/")
    public String paymentConsul(){
        return "springCloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
