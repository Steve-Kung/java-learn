package com.steve.pojo;

import com.steve.mapper.UserMapper;
import com.steve.utils.UserUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: http://www.stevekung.com
 * @Date: 2019/12/30
 * @Description: com.steve.pojo
 * @version: 1.0
 */
public class UserTest {
    @Test
    public void getUsers(){
        SqlSession sqlSession = UserUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void selectUserByIdTest(){
        SqlSession sqlSession = UserUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUserTest(){
        SqlSession sqlSession = UserUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(3,"jg","456"));
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        // 增删改操作都需要提交事务，查询操作不需要,否则数据库那边更新不了
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = UserUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(3);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        // 增删改操作都需要提交事务，查询操作不需要,否则数据库那边更新不了
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = UserUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(2,"jg","456"));
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        // 增删改操作都需要提交事务，查询操作不需要,否则数据库那边更新不了
        sqlSession.commit();
        sqlSession.close();
    }
}
