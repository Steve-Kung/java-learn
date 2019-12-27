package com.steve.pojo;

public class UserServiceProxy implements UserService {
    UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void updata() {
        log("updata");
        userService.updata();
    }

    public void query() {
        log("query");
        userService.query();
    }

    public void log(String msg){
        System.out.println("代理额外操作：进入" + msg + "方法");
    }
}
