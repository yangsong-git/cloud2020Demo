package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangsong
 * @date 2021/4/19 19:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulMain8000.class,args);
    }
}
