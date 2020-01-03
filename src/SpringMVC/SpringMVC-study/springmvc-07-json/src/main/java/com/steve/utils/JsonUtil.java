package com.steve.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

public class JsonUtil {
    // 传入要转化为Json数据的对象object和日期转换格式sdf
    public static String getJson(Object object, String pattern) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        mapper.setDateFormat(sdf);
        String str = mapper.writeValueAsString(object);
        return str;
    }

    // 重载
    // 传入要转化为Json数据的对象object，默认日期转换格式pattern "yyyy-MM-dd HH-mm-ss"
    public static String getJson(Object object) throws JsonProcessingException {
        return getJson(object, "yyyy-MM-dd HH-mm-ss");
    }
}
