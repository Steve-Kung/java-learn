package com.steve.mapper;

import com.steve.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
//    SqlSessionTemplate sqlSession;
//
//    public void setSqlSession(SqlSessionTemplate sqlSession) {
//        this.sqlSession = sqlSession;
//    }

    public List<User> selectUsers() {
        User user = new User(4,"steve", "456");
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        mapper.addUser(user);
        mapper.deleteUser(4);
        List<User> users = mapper.selectUsers();
        return users;
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }

    public User selectUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).selectUser(id);
    }

    public User updateUser(int id, String pwd) {
        return getSqlSession().getMapper(UserMapper.class).updateUser(id, pwd);
    }
}
