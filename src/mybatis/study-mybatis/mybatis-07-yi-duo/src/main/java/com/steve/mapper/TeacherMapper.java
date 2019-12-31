package com.steve.mapper;

import com.steve.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher> getTeachers();
    public List<Teacher> getTeachers2();

}
