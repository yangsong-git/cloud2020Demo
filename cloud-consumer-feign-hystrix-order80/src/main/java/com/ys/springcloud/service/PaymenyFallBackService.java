package com.ys.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yangsong
 * @date 2021/5/18 22:35
 */
@Component
public class PaymenyFallBackService implements PaymentFeignService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "挂了走这里---PaymenyFallBackService --- paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "挂了走这里---PaymenyFallBackService --- paymentInfo_timeout";
    }
}
