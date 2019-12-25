package com.steve.test;


import com.steve.dao.UserDaoMysqlImpl;
import com.steve.dao.UserDaoOracleImpl;
import com.steve.service.UserService;
import com.steve.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsedTest {
    // 以前的写法
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        service.getUser();
    }

    @Test
    public void test1(){
        // 以前所有东西都是由程序去进行控制创建 ,
        // 而现在是由我们自行控制创建对象 , 把主动权交给了调用者 .
        // 程序不用去管怎么创建,怎么实现了 . 它只负责提供一个接口 .
        // 程序员不再去管理对象的创建了 , 更多的去关注业务的实现 .
        // 耦合性大大降低 . 这也就是IOC的原型 !
        UserServiceImpl service = new UserServiceImpl();
        service.setUserDao(new UserDaoMysqlImpl());
        service.getUser();
        // 那我们现在又想用Oracle去实现呢
        service.setUserDao(new UserDaoOracleImpl());
        service.getUser();

        // 控制反转IoC(Inversion of Control)，是一种设计思想，
        // DI(依赖注入)是实现IoC的一种方法，
        // 控制反转就是：获得依赖对象的方式反转了,
        // IOC容器就是第三方。
        // 控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入（Dependency Injection,DI）。

    }

    @Test
    public void test2(){
        // 获取ApplicationContext, 拿到Spring的容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // 容器在手，天下我有，需要什么。就直接get什么。工厂模式
        UserServiceImpl serviceImpl = (UserServiceImpl)applicationContext.getBean("serviceImpl");
        serviceImpl.getUser();
    }

}
