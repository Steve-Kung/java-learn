import com.steve.config.UserConfig;
import com.steve.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 完全不用配置文件
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        User getUser = context.getBean("getUser", User.class);
        System.out.println(getUser.getName());
    }
}
