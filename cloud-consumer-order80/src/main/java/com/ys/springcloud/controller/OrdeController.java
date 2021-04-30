package com.ys.springcloud.controller;

import com.ys.springcloud.core.ResultVo;
import com.ys.springcloud.core.ResultVoFactory;
import com.ys.springcloud.lb.MyLoadBalanced;
import com.ys.springcloud.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MyLoadBalanced myLoadBalanced;
    @Autowired
    private DiscoveryClient discoveryClient;
    /**
     * 插入数据
     * @author   yangsong
     * @date     2021/4/16 19:34
     * @param payment: 插入数据的对象
     * @return: com.ys.springcloud.core.ResultVo<com.ys.springcloud.model.Payment>
     */
    @GetMapping("/insertOrUpdatePayment")
    public ResultVo<Payment> insertOrUpdatePayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/insertOrUpdatePayment",payment,ResultVo.class);
//        return ResultVoFactory.successResult("","操作成功");
    }
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
        ResponseEntity<ResultVo> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id + "/", ResultVo.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return ResultVoFactory.errorResult("查询失败");
        }
//        return ResultVoFactory.successResult("","操作成功");
    }
    @GetMapping(value = "getServerPort")
    public String getServerProt(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (!CollectionUtils.isEmpty(instances)){
            ServiceInstance instance = myLoadBalanced.instance(instances);
           return restTemplate.getForObject(instance.getUri()+"/payment/getServerPort/",String.class);
        }
        return null;
    }
}
