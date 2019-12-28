package com.steve.mapper;

import com.steve.pojo.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> selectStudents();
    public int addStudent(Student student);
    public int deleteStudent(int id);
    public int updateStudent(int id, String pwd);
    public Student selectStudent(int id);
}
