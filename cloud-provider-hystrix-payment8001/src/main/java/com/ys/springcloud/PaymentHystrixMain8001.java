package com.ys.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangsong
 * @date 2021/4/23 20:56
 */
@SpringBootApplication
@EnableEurekaServer
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
            SpringApplication.run(PaymentHystrixMain8001.class,args);
        }
}
