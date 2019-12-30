package reflection;

import org.junit.Test;
import reflection.pojo.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1() throws Exception {
        Class clazz = User.class;
        // 反射创建一个对象
        User user = (User)clazz.newInstance();

        //--------------------------------------------
        // 通过反射获取属性
        Field name = clazz.getDeclaredField("name");
        // private 得开放访问修改属性
        name.setAccessible(true);
        // 设置属性值
        name.set(user,"steve");
        System.out.println(user.getName());

        //--------------------------------------------
        // 通过反射获取方法
        Method method1 = clazz.getDeclaredMethod("say",int.class,String.class);

        method1.setAccessible(true);
        // 反射方法调用通过invoke方法
        method1.invoke(user,3,"hello world");


    }

}
