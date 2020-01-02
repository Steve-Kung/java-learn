package com.steve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EncodingController {
    // 解决乱码，使用过滤器
    // 第一种，自己重写的过滤器
//    @RequestMapping("/encoding")
    @PostMapping("/encoding")
    public String encoding(Model model,@RequestParam("userName") String name){
        model.addAttribute("msg",name);
        return "encoding";
    }
    // 第二种使用spring官方的过滤器
}
