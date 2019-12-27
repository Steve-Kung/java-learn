package com.steve.pojo;

// 真实实现类
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("真实实现类：这是add方法");
    }

    public void delete() {
        System.out.println("真实实现类：这是delete方法");
    }

    public void updata() {
        System.out.println("真实实现类：这是updata方法");
    }

    public void query() {
        System.out.println("真实实现类：这是query方法");
    }
}
