package com.steve.pojo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 进一步抽象为万能工具类
public class ProInvocationHandler implements InvocationHandler{
    // 需要动态代理的接口
    private Object target;

    // set方法
    public void setTarget(Object target) {
        this.target = target;
    }

    // 获取动态代理实例
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }
}
