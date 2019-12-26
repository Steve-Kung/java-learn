import com.steve.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user1 = context.getBean("user", User.class);
        System.out.println(user1.toString());
        User user2 = context.getBean("user", User.class);
        System.out.println(user2.toString());
        System.out.println(user1 == user2);
        user1.getDog().shout();
        user2.getCat().shout();
    }
}
