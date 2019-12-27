package com.steve.pojo;

// 代理类
public class ProxyTwo implements Rent {
    HostTwo hostTwo;

    public void setHost(HostTwo hostTwo) {
        this.hostTwo = hostTwo;
    }

    public void rent() {
        // 实际操作的还是房东的操作
        System.out.println("进入代理操作");
        fee();
        hostTwo.rent();
        System.out.println("退出代理操作");
    }
    public void fee(){
        System.out.println("代理额外操作, 收取代理费");
    }
}
