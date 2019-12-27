package com.steve.pojo;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setUserService(userService);
        UserService proxy = (UserService)pih.getProxy();
        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.select();
        UserServiceImplTwo userServiceTwo = new UserServiceImplTwo();
        pih.setUserService(userServiceTwo);
        UserService proxy2 = (UserService)pih.getProxy();
        proxy2.add();
        proxy2.delete();
        proxy2.update();
        proxy2.select();
    }

}
