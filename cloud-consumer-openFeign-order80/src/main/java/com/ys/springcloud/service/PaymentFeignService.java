package com.ys.springcloud.service;

import com.ys.springcloud.core.ResultVo;
import com.ys.springcloud.core.ResultVoFactory;
import com.ys.springcloud.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author   yangsong
 * @date     2021/4/23 19:34
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {
    /**
     *
     * 根据id，查询对象
     * @author   yangsong
     * @date     2020-06-12
     * @param id   主键ID
     * @return ResultVo
     */
    @GetMapping(value = "/payment/getPaymentById/{id}/")
    ResultVo<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 新增或更新方法
     *
     * @author   yangsong
     * @date     2020-06-12
     * @param payment
     * @return ResultVo
     */
    @PostMapping(value="/payment/insertOrUpdatePayment")
    ResultVo<String> insertOrUpdatePayment(@RequestBody Payment payment);

    @GetMapping(value = "/payment/paymentFeign/")
    public String paymentFeign();
}



