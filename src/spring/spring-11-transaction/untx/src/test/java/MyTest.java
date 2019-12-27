import com.steve.mapper.UserMapperImpl;
import com.steve.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mapper.xml");
        UserMapperImpl userMapperImpl = context.getBean("userMapperImpl", UserMapperImpl.class);
        List<User> users = userMapperImpl.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
