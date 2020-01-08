package com.steve.controller;

import com.steve.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {
    @ResponseBody
    @RequestMapping("/ajax")
    public String ajaxController(){
        String result = "hello ajax!";
        return result;
    }


    @RequestMapping("/onBlur")
    public void onBlur(String name, HttpServletResponse response) throws IOException {
        if("steve".equals(name)){
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/ajax2")
    @ResponseBody
    public List<User> ajax2(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("steve", 12, "男"));
        userList.add(new User("gj", 12, "男"));
        userList.add(new User("jg", 12, "女"));
        return userList; //由于@RestController注解，将msg转成json格式返回
    }

    @RequestMapping("/ajax3")
    @ResponseBody
    public String ajax3(String username, String password){
        String msg=null;
        if(username!=null){
            if("steve".equals(username)){
                msg = "OK";
            } else {
                msg = "用户名输入有误";
            }
        }
        if(password!=null){
            if("123456".equals(password)){
                msg = "OK";
            } else {
                msg = "密码输入有误";
            }
        }
        return msg; //由于@RestController注解，将msg转成json格式返回
    }

}


