package com.steve.pojo;

// 代理类
public class Proxy implements Rent {
    Host host;

    public void setHost(Host host) {
        this.host = host;
    }

    public void rent() {
        // 实际操作的还是房东的操作
        System.out.println("进入代理操作");
        fee();
        host.rent();
        System.out.println("退出代理操作");
    }
    public void fee(){
        System.out.println("代理额外操作, 收取代理费");
    }
}
