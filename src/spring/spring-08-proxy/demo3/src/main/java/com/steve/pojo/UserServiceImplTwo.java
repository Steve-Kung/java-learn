package com.steve.pojo;

public class UserServiceImplTwo implements UserService {
    public void add() {
        System.out.println("另一服务函数执行add方法");
    }

    public void delete() {
        System.out.println("另一服务函数执行delete方法");
    }

    public void update() {
        System.out.println("另一服务函数执行update方法");
    }

    public void select() {
        System.out.println("另一服务函数执行select方法");
    }
}
