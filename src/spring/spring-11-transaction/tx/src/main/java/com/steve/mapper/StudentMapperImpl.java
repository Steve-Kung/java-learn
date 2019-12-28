package com.steve.mapper;

import com.steve.pojo.Student;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class StudentMapperImpl extends SqlSessionDaoSupport implements StudentMapper {
    public List<Student> selectStudents() {
        // 验证事务的ACID原子一致隔离持久性
        Student steve = new Student(3, "steve", "123456");
        StudentMapper mapper = getSqlSession().getMapper(StudentMapper.class);
        mapper.addStudent(steve);
        mapper.deleteStudent(3);
        return getSqlSession().getMapper(StudentMapper.class).selectStudents();
    }

    public int addStudent(Student student) {
        return getSqlSession().getMapper(StudentMapper.class).addStudent(student);
    }

    public int deleteStudent(int id) {
        return getSqlSession().getMapper(StudentMapper.class).deleteStudent(id);
    }

    public int updateStudent(int id, String pwd) {
        return getSqlSession().getMapper(StudentMapper.class).updateStudent(id, pwd);
    }

    public Student selectStudent(int id) {
        return getSqlSession().getMapper(StudentMapper.class).selectStudent(id);
    }
}
