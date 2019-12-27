package com.steve.pojo;

public class Client {
    // 静态代理每换一次代理对象，代理类都得再次实现一遍，即便他们具有相同的实现接口，编码工作量巨大
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy();
        proxy.setHost(host);
        proxy.rent();
        HostTwo hostTwo = new HostTwo();
        ProxyTwo proxy2 = new ProxyTwo();
        proxy2.setHost(hostTwo);
        proxy2.rent();
    }


}
