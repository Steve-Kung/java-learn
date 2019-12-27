package com.steve.diy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DiyAopAspect {

    @Before("execution(* com.steve.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("========|-前-|========");
    }
    @After("execution(* com.steve.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("========|-后-|========");
    }
}
