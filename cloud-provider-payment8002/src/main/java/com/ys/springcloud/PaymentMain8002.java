package com.ys.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * 功能描述:
 *
 * @version jdk1.8
 * @ClassName PaymentMain8001
 * @Author yangsong
 * @Date 2020/6/11 13:38
 **/
@SpringBootApplication
@MapperScan("com.ys.springcloud.dao")
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
