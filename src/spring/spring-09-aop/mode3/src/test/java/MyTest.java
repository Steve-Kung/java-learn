import com.steve.config.ServiceConfig;
import com.steve.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.select();
        userService.add();
    }
}
