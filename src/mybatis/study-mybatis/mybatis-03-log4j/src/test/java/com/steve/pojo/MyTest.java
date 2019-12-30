package com.steve.pojo;

import com.steve.mapper.UserMapper;
import com.steve.utils.UserUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

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
    }
}
