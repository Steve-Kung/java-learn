package spring.ioc.used.dao;

public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Mysql获取用户数据");
    }
}
