package com.steve.controller;

import com.steve.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class HelloController{
//    传统请求风格 ? 问号后面带参数a ,b ,同名配对
// http://localhost:8080/hello?a=1&b=2
    @RequestMapping("/hello")
    public String hello(Model model, int a, int b){
        int result = a + b;
        model.addAttribute("msg", result);
        return "hello";
    }

    // Restful风格请求,不用？用/
//    @RequestMapping(value = "/hello/{a}/{b}", method = RequestMethod.GET)
    @GetMapping("/hello/{a}/{b}")
    public String helloRESTFUL1(Model model, @PathVariable int a,@PathVariable int b){
        int result = a + b;
        model.addAttribute("msg", result + "get方式");
        return "hello";
    }

    @PostMapping("/hello/{a}/{b}")
    public String helloRESTFUL2(Model model, @PathVariable int a,@PathVariable int b){
        int result = a + b;
        model.addAttribute("msg", result + "post方式");
//        return "hello"; // 转发
        return "redirect:/redirect.jsp"; // 重定向
    }

    // 接收请求参数及数据回显
    // 接收的是一个对象，属性名与传递参数一一对应
    @GetMapping("/hello/{id}/{name}/{age}")
    public String helloParameter(User user, Model model){
        System.out.println(user);
        model.addAttribute("msg", user);
        return "hello";
    }

    // 接收请求参数及数据回显
    // 接收的是一个数据，数据名与传递参数一一对应
    // 如果名字不一致，使用@PathVariable("haha")指定
    @GetMapping("/hello/{haha}")
    public String helloParameter1(@PathVariable("haha") String userName, Model model){
        System.out.println(userName);
        model.addAttribute("msg", userName);
        return "hello";
    }
}
