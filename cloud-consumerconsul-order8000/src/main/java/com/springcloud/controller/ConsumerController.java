package com.springcloud.controller;

import com.ys.springcloud.core.ResultVo;
import com.ys.springcloud.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author yangsong
 * @date 2021/4/19 19:42
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    public static final String INVOLE_URL = "http://consul-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @author   yangsong
     * @date     2021/4/19 20:03
     * @return: com.ys.springcloud.core.ResultVo<com.ys.springcloud.model.Payment>
     */
    @GetMapping("/getPaymentInfo/")
    public String getPaymentInfo(){
        return restTemplate.getForObject(INVOLE_URL+"/payment/consul/",String.class);
//        return ResultVoFactory.successResult("","操作成功");
    }
}
