package com.steve.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.steve.pojo.User;
import com.steve.utils.JsonUtil;
import javafx.scene.chart.PieChart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// controller输出json数据给前端
// Jackson可以轻松的将Java对象转换成json对象和xml文档
// 导包
@Controller
@RequestMapping(("/json"))
public class JsonController {

    // 返回单个对象JSON
    @RequestMapping("/t1")
    public String test1(Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1, "steve", "男");
        String str = mapper.writeValueAsString(user);
        model.addAttribute("msg", str);
        return "json";
    }
    @RequestMapping("/t2")
    // 不经过视图解析器
    // 要解决以下jackson中文乱码问题
    @ResponseBody  // @RestController= @Controller+@ResponseBody
    public String test2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1, "steve", "男");
        String str = mapper.writeValueAsString(user);
        return str;
    }

    //返回整个集合JSON
    @RequestMapping("/t3")
    @ResponseBody
    public String test3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "steve", "男"));
        userList.add(new User(2, "gj", "女"));
        userList.add(new User(3, "jg", "男"));
        String str = mapper.writeValueAsString(userList);
        return str;
    }

    // 返回一个日期使用时间戳的方式 1578045830722 long型数据
    @RequestMapping("/t4")
    @ResponseBody
    public String test4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        String s = mapper.writeValueAsString(date);
        return s;
    }

    // 返回一个日期 "2020-01-03 18-10-25"
    @RequestMapping("/t5")
    @ResponseBody
    public String test5() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        // 改造Date显示的时间格式 "2020-01-03 18-10-25"
        String format = sdf.format(date);
        String s = mapper.writeValueAsString(format);
        return s;
    }

    // 返回一个日期 "2020-01-03 18-16-04"
    @RequestMapping("/t6")
    @ResponseBody
    public String test6() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        //指定日期格式
        // 改造mapper不使用时间戳的方式
        mapper.setDateFormat(sdf);
        String str = mapper.writeValueAsString(new Date());
        return str;
    }

    // 构建一个工具类JsonUtil,并使用
    @RequestMapping("/t7")
    @ResponseBody
    public String test7() throws JsonProcessingException {
        User user = new User(1, "steve", "男");
        String json1 = JsonUtil.getJson(user);
        Date date = new Date();
        String json2 = JsonUtil.getJson(date);
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "steve", "男"));
        userList.add(new User(2, "gj", "女"));
        userList.add(new User(3, "jg", "男"));
        String json3 = JsonUtil.getJson(userList);
//        return json1;
//        return json2;
        return json3;
    }

    // 使用阿里巴巴的fastJson
    // 可以方便的实现json对象与JavaBean对象的转换，实现JavaBean对象与json字符串的转换，
    // 实现json对象与json字符串的转换。
    // 导包 fastjson
    /**
     * 【JSONObject 代表 json 对象 】
     JSONObject实现了Map接口, 猜想 JSONObject底层操作是由Map实现的。
     JSONObject对应json对象，通过各种形式的get()方法可以获取json对象中的数据，也可利用诸如size()，isEmpty()等方法获取"键：值"对的个数和判断是否为空。其本质是通过实现Map接口并调用接口中的方法完成的。
     【JSONArray 代表 json 对象数组】
     内部是有List接口中的方法来完成操作的。
     【JSON 代表 JSONObject和JSONArray的转化】
     JSON类源码分析与使用
     仔细观察这些方法，主要是实现json对象，json对象数组，javabean对象，json字符串之间的相互转化。
     */
    @RequestMapping("/t8")
    @ResponseBody
    public void test8(){
        //创建一个对象
        User user1 = new User(3,"steve","男");
        User user2 = new User(3,"steve","男");
        User user3 = new User(3,"steve","男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);
    }
}