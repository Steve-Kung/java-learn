package com.steve.pojo;

public class Client {
    // 静态代理每换一次代理对象，代理类都得再次实现一遍，即便他们具有相同的实现接口，编码工作量巨大
    // 动态代理每换一次代理对象，如果他们具有相同的实现接口，代理类可以直接动态生成，节约编码工作量
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ProInvocationHandler pih = new ProInvocationHandler();
        pih.setTarget(userService);
        UserService proxy = (UserService) pih.getProxy();
        proxy.add();
        proxy.delete();
        UserServiceImplTwo userServiceTwo = new UserServiceImplTwo();
        pih.setTarget(userServiceTwo);
        UserService proxy2 = (UserService) pih.getProxy();
        proxy2.update();
        proxy2.select();

    }

}
