package com.ys.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author yangsong
 * @date 2021/4/19 21:34
 */
public class MySelfRule {
    @Bean
    public IRule getRandomRule(){
        // 定义ribbon为随机算法
        return new RandomRule();
    }
}
