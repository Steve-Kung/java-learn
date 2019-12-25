package spring.ioc.used.service;

import spring.ioc.used.dao.UserDao;
import spring.ioc.used.dao.UserDaoImpl;
import spring.ioc.used.dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService {
    //-------以前的方法---------
    // 那么我们要使用Oracle , 又需要去service实现类里面修改对应的实现 .
    // 假设我们的这种需求非常大 , 这种方式就根本不适用了, 甚至反人类对吧 ,
    // 每次变动 , 都需要修改大量代码 . 这种设计的耦合性太高了, 牵一发而动全身 .
//    private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao = new UserDaoMysqlImpl();

    //-------现在的方法---------
    // 可以在需要用到他的地方 , 不去实现它 , 而是留出一个接口 , 利用set
    private UserDao userDao;
    // 利用set实现
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
