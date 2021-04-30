package com.ys.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yangsong
 * @date 2021/4/23 21:00
 */
@Service

public class PaymentService {
    public String paymentInfo_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_ok,id:   "+id+"    😄";
    }



    public String paymentInfo_timeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_timeout,id:   "+id+"    😄  耗时"+timeNumber+"秒";
    }
}
