package com.steve.controller;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("/user/login")
    public String login(String userName, String password, HttpSession session){
        // 向session记录用户身份信息
        session.setAttribute("userName", userName);
        return "success";

    }

    @RequestMapping("/user/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        // 清除session中的属性
        session.removeAttribute("userName");
        return "redirect:/index.jsp";
    }
}
