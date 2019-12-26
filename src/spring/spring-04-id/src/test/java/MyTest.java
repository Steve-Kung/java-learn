import com.steve.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("gj");
        System.out.println(student.toString());
        /*
        Student{
            name='gjj',
            hobbies=["swim", "run"],
            books=["语文", "数学"],
            balls=["篮球", "足球"],
            cards={idCard=1233456789, yhcard=147258369},
            jdbc={password=123456, username="gjj"},
            address=Address{name='zju'}}
         */
    }
}
