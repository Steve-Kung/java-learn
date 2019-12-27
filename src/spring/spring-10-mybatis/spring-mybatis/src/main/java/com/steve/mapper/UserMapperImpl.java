package com.steve.mapper;

import com.steve.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{
    // 引入SqlSessionTemplate
    private SqlSessionTemplate sqlSession;

    // set方法 可以直接注入
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUsers() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUsers();
        return users;
    }
}
