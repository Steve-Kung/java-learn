package com.steve.mapper;

import com.steve.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User> getUsers();

    // 分页查询
    public List<User> getUserByLimit(Map<String, Integer> map);
}
