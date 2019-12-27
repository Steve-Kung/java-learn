package com.steve.log;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class BeforeLog implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("=======前=======");
    }
}
