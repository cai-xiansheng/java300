package TestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author 张辉
 * @Description 使用反射读取注解的信息，模拟处理注解信息的流程
 * @create 2020-06-27 10:36
 */
public class Demo03 {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("TestAnnotation.MyStudent");

            // 获得类的所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }

            // 获取类指定的注解
            MyTable mt = (MyTable) clazz.getAnnotation(MyTable.class);
            System.out.println(mt);

            // 获得类的属性的注解
            Field f = clazz.getDeclaredField("studentName");
            MyFiled myFiled = f.getAnnotation(MyFiled.class);
            System.out.println(myFiled.columnName() + "---" + myFiled.type() + "---" + myFiled.length());

            // 根据获取的表名、字段的信息，拼出DDL语句，然后使用JDBC 执行这个SQL，在数据库中生成相应的表。

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
