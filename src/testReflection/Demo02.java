package testReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 张辉
 * @Description 应用反射的API，获取类的信息（类的名字、属性、方法、构造器）；
 * @create 2020-06-27 20:28
 */
@SuppressWarnings("all")
public class Demo02 {
    public static void main(String[] args) {
        String path = "testReflection.bean.User";
        try {
            Class clazz = Class.forName(path);
            System.out.println(clazz);

            // 获取类的名称
            System.out.println(clazz.getName()); // 获取包名+类名：testReflection.bean.User
            System.out.println(clazz.getSimpleName()); // 获取类名：User

            // 获取属性信息
            //Field[]  fields = clazz.getFields(); // 只能获得public的field
            Field[] fields = clazz.getDeclaredFields(); // 获得所有的Field
            Field f = clazz.getDeclaredField("uname"); // 通过指定名称获取属性
            System.out.println(f);
            System.out.println(fields.length);
            for (Field tmp : fields) {
                System.out.println("属性:" + tmp);
            }

            // 获取方法信息
            Method[] methods = clazz.getDeclaredMethods(); // 获取全部方法
            Method m01 = clazz.getDeclaredMethod("getUname", null);
            Method m02 = clazz.getDeclaredMethod("setUname", String.class);
            // 如果方法有参，则必须传递参数类型对应的class对象
            System.out.println(m02);
            for (Method m : methods) {
                System.out.println("方法：" + m);
            }

            // 获取构造器信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            Constructor c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            System.out.println("获得构造器：" + c);
            for (Constructor constructor : constructors) {
                System.out.println("构造器：" + constructor);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
