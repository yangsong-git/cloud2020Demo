package com.ys.springcloud.controller;

import com.ys.springcloud.core.ResultVo;
import com.ys.springcloud.core.ResultVoFactory;
import com.ys.springcloud.model.Payment;
import com.ys.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangsong
 * @date 2021/4/23 19:42
 */
@RestController
@RequestMapping("consumer/")
public class OrderFeignController {
    @Autowired
    PaymentFeignService paymentFeignService;

    /**
     * 根据ID查询数据
     *
     * @author   yangsong
     * @date     2021/4/16 19:34
     * @param id:
     * @return: com.ys.springcloud.core.ResultVo<com.ys.springcloud.model.Payment>
     */
    @GetMapping("/getPaymentById/{id}")
    public ResultVo<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/paymentFeign/")
    public String paymentFeign(){
        return paymentFeignService.paymentFeign();
    }
}
