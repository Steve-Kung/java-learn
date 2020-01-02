package com.steve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/controller")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg", "hello, controller");
        return "hello";
    }

    @RequestMapping("/hello1")
    public String hello1(Model model){
        model.addAttribute("msg", "hello1, controller");
        return "hello";
    }
}
