package com.steve.mapper;

import com.steve.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User> getUsers();

    public List<User> selectUserLikeName(String name);

    // 改一个数据需要传入全部参数
//    public void updateUser(User user);
    // 使用parameterMap传入多个参数，只改需要改动的参数
    public void updateUser(Map<String, Object> map);

    public User selectUserById(int id);

}
