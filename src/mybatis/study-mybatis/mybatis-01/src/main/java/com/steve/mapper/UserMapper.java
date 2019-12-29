package com.steve.mapper;

import com.steve.pojo.User;

import java.util.List;

/**
 * @Auther: http://www.stevekung.com
 * @Date: 2019/12/30
 * @Description: com.steve.mapper
 * @version: 1.0
 */
public interface UserMapper {
    public List<User> getUsers();

    public User selectUserById(int id);

    public void addUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);
}
