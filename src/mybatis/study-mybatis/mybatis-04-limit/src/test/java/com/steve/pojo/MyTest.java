package com.steve.pojo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.steve.mapper.UserMapper;
import com.steve.utils.UserUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {


    @Test
    public void getUsers(){
        Logger logger = Logger.getLogger(this.getClass());
        logger.info("info: 使用logger");
        logger.debug("debug: 使用logger");
        logger.error("error: 使用logger");

        SqlSession sqlSession = UserUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void limitTest(){
        SqlSession sqlSession = UserUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void pageHelper(){
        SqlSession sqlSession = UserUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 查询很有意思，只需要在执行查询所有的调用之前，执行一条语句即可：
        PageHelper.offsetPage(0, 2);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("=================");
        PageInfo pageInfo = new PageInfo<User>(users);
        System.out.println("总数："+pageInfo.getTotal());
        System.out.println("=================");
        System.out.println(pageInfo);
        sqlSession.close();
    }
}
