package com.ys.springcloud.controller;

import com.ys.springcloud.core.ResultVo;
import com.ys.springcloud.core.ResultVoFactory;
import com.ys.springcloud.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 功能描述：
 *
 * @version jdk1.8
 * @ClassName OrdeController
 * @Author yangsong
 * @Date 2020/6/23 14:19
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrdeController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/insertOrUpdatePayment")
    public ResultVo<Payment> insertOrUpdatePayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/insertOrUpdatePayment",payment,ResultVo.class);
//        return ResultVoFactory.successResult("","操作成功");
    }
    @GetMapping("/getPaymentById/{id}")
    public ResultVo<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id+"/",ResultVo.class);
//        return ResultVoFactory.successResult("","操作成功");
    }
}
