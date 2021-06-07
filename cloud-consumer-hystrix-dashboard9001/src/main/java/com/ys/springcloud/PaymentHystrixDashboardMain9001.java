package com.ys.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author yangsong
 * @date 2021/5/19 13:42
 */
@SpringBootApplication
@EnableHystrixDashboard
public class PaymentHystrixDashboardMain9001 {
    public static void main(String[] args) {
            SpringApplication.run(PaymentHystrixDashboardMain9001.class,args);
        }
}
