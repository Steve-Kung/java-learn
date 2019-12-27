package com.steve.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    // 要动态代理的接口
    private UserService userService;

    // set方法注入
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 生成动态代理类对象
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), userService.getClass().getInterfaces(),this);
    }

    // 利用反射实现方法调用
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log(method.getName());
        Object result = method.invoke(userService, args);
        return result;
    }

    public void Log(String msg){
        System.out.println("代理额外方法：进入" + msg + "方法");
    }
}
