package com.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 功能描述：
 *
 * @version jdk1.8
 * @ClassName ApplicationContextConfig
 * @Author yangsong
 * @Date 2020/6/23 14:23
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  // 负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
