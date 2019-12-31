package com.steve.mapper;

import com.steve.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    public List<User> getUsers();

    @Insert("insert into user (id, name, pwd) values (#{id}, #{name}, #{pwd})")
    public void addUser(User user);

    @Delete("delete from user where id=#{uid}")
    public void deleteUser(@Param("uid") int id);

    @Update("update user set name=#{name}, pwd=#{pwd} where id=#{id}")
    public void updateUser(User user);
}
