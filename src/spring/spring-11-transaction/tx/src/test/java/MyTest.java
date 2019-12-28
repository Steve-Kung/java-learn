import com.steve.mapper.StudentMapper;
import com.steve.mapper.StudentMapperImpl;
import com.steve.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mapper.xml");
        StudentMapper impl = context.getBean("studentMapperImpl", StudentMapper.class);
        // 增
//        Student student1 = context.getBean("student", Student.class);
//        student1.setId(3);
//        student1.setName("steve");
//        student1.setPwd("123456");
//        impl.addStudent(student1);
        // 删
//        impl.deleteStudent(3);
        // 改
//        impl.updateStudent(2,"123");
        // 查
//        Student student1 = impl.selectStudent(2);
//        System.out.println(student1);
//        System.out.println("===========");
        List<Student> students = impl.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
