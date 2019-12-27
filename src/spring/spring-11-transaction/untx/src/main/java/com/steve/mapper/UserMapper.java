package com.steve.mapper;

import com.steve.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectUsers();
    public int addUser(User user);
    public int deleteUser(int id);
    public User selectUser(int id);
    public User updateUser(int id, String pwd);
}
