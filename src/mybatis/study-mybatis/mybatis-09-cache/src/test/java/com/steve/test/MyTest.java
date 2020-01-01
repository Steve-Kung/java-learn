package com.steve.test;

import com.steve.mapper.UserMapper;
import com.steve.pojo.User;
import com.steve.utils.IdUtil;
import com.steve.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void selectUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        在一个sqlSession 本地缓存级别 一级缓存
//        只到数据库一次 一级缓存下来了
        User user1 = mapper.selectUserById(1);
        User user2 = mapper.selectUserById(1);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1 == user2);
        sqlSession.close();
    }

    @Test
    public void selectUserById2(){
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.selectUserById(1);
        System.out.println(user1);
        sqlSession1.close();
//        一级缓存拷贝到二级缓存中
//        只到数据库一次，二级缓存下来了

        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.selectUserById(1);

        System.out.println(user2);
        System.out.println(user1 == user2);
        sqlSession2.close();
    }
}
