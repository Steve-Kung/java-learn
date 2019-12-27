import com.steve.controller.UserController;
import com.steve.dao.UserDao;
import com.steve.pojo.User;
import com.steve.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        UserController userController = context.getBean("userController", UserController.class);
        UserService userService = context.getBean("userService", UserService.class);
        userDao.userDao();
        userController.userController();
        userService.userService();
        User user = context.getBean("user", User.class);
        user.getCat().shout();
        user.getDog().shout();
        System.out.println(user.toString());
    }
}
