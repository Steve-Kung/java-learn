import com.steve.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: http://www.stevekung.com
 * @Date: 2019/12/26
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class MyTest {
    public static void main(String[] args) {
//        User user = new User();
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // Spring默认使用无参构造函数，创建对象
        User user = (User)classPathXmlApplicationContext.getBean("user");
    }
}
