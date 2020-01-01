package com.steve.mapper;

import com.steve.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User selectUserById(@Param("uid") int id);
}
