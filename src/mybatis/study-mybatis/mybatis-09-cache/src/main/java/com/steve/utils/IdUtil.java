package com.steve.utils;

import org.junit.Test;

import java.util.UUID;

public class IdUtil {
    public static String getId(){
        String s = UUID.randomUUID().toString().replaceAll("-","");
        return s;
    }

    @Test
    public void test(){
        String id = IdUtil.getId();
        System.out.println(id);
        id = IdUtil.getId();
        System.out.println(id);
        id = IdUtil.getId();
        System.out.println(id);
    }
}
