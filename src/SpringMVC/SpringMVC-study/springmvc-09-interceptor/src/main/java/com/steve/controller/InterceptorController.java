package com.steve.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//测试拦截器的控制器
@Controller
public class InterceptorController {
    @RequestMapping("/interceptor")
    @ResponseBody
    public String intercepter(){
        System.out.println("拦截器控制器中的执行方法");
        return "hello";
    }

}