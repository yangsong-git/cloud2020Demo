package com.ys.springcloud.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author yangsong
 * @date 2021/6/16 12:53
 */
@Component
@Aspect
public class AopAspect {


    @Pointcut("@annotation(AopTest)")
    public  void setJoinPoint(){
        System.out.println("*********************");
    }
    @Around(value = "setJoinPoint()")
    public void aroundMethod()  {
        System.out.println("【AOP】拦截到带@AutoCache注解的方法:");
    }
}
