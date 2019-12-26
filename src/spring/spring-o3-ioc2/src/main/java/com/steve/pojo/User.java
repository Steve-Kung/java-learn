package com.steve.pojo;

/**
 * @Auther: http://www.stevekung.com
 * @Date: 2019/12/26
 * @Description: com.steve.pojo
 * @version: 1.0
 */
public class User {
    private String name;

//    public User() {
//        System.out.println("无参构造器");
//    }

    public User(String name) {
        this.name = name;
        System.out.println("有参构造器");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
