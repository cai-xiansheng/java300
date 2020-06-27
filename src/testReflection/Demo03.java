package testReflection;

import testReflection.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 张辉
 * @Description 通过反射API冬天操作：构造器、方法、属性
 * @create 2020-06-27 21:17
 */
@SuppressWarnings("all")
public class Demo03 {
    public static void main(String[] args) {
        String path = "testReflection.bean.User";
        try {
            Class<User> clazz = (Class<User>) Class.forName(path);

            // 通过反射API调用构造方法，构造对象
            User u = clazz.newInstance(); // 其实调用了User的无参构造器
            System.out.println(u);

            Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2 = c.newInstance(1001,18,"张三");
            System.out.println(u2.getUname());

            // 通过反射API调用普通方法
            User u3 = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class); // 获取methods
            method.invoke(u3,"张三");
            // 上面两行就相当于实现了  u3.setUname("张三");
            System.out.println(u3.getUname());

            // 通过反射API操作属性
            User u4 = clazz.newInstance();
            Field f = clazz.getDeclaredField("uname");
            f.setAccessible(true); // 这个属性不需要作安全检查了，可以直接访问
            f.set(u4,"张三4"); // 通过反射直接写属性
            System.out.println(u4.getUname()); // 通过反射直接读属性的值
            System.out.println(f.get(u4)); // 通过反射直接读属性的值


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
