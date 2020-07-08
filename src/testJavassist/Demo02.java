package testJavassist;

import javassist.*;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 张辉
 * @Description 测试javassist的API
 * @create 2020-07-07 21:50
 */
public class Demo02 {

    /**
     * 处理类的基本用法
     */
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("testJavassist.Emp");
        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));

        System.out.println(cc.getName()); // 获取类名
        System.out.println(cc.getSimpleName()); // 获取简要类名
        System.out.println(cc.getSuperclass()); // 获取父类
        System.out.println(cc.getInterfaces()); // 获取接口

    }

    /**
     * 测试产生新的方法
     */
    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("testJavassist.Emp");

        //CtMethod m = CtNewMethod.make("public int add(int a,int b) {return a + b;}", cc);

        CtMethod m = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType, CtClass.intType}, cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{System.out.println(\"cccc\");return $1 + $2;}");
        cc.addMethod(m);


        // 通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance(); // 通过调用Emp无参构造器，创建新的Emp对象
        Method method = clazz.getDeclaredMethod("add", int.class, int.class);
        Object result = method.invoke(obj, 100, 200);
        System.out.println(result);

    }

    /**
     * 修改已有方法的信息
     *
     * @throws Exception
     */
    public static void test03() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("testJavassist.Emp");

        CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!\");");
        cm.insertAfter("System.out.println(\"end!!\");");
        cm.insertAt(38, "int b = 3;System.out.println(\"b=\" + b);");


        // 通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance(); // 通过调用Emp无参构造器，创建新的Emp对象
        Method method = clazz.getDeclaredMethod("sayHello", int.class);
        Object result = method.invoke(obj, 10);
        System.out.println(result);
    }

    /**
     * 属性的set和get操作
     * @throws Exception
     */
    public static void test04() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("testJavassist.Emp");

        // 创建新的属性
        //CtField f1 = CtField.make("private int empno;", cc);
        CtField f1 = new CtField(CtClass.intType, "salary", cc);
        f1.setModifiers(Modifier.PRIVATE);
        cc.addField(f1, "1000"); // 默认为1000

        //cc.getDeclaredField("ename"); // 获取指定的属性

        // 增加相应的set和get方法
        cc.addMethod(CtNewMethod.getter("setSalary",f1));
        cc.addMethod(CtNewMethod.getter("getSalary",f1));

    }


    /**
     * 构造器方法操作
     * @throws Exception
     */
    public static void test05() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("testJavassist.Emp");

        CtConstructor[] cs = cc.getConstructors();
        for(CtConstructor c: cs) {
            System.out.println(c.getLongName());
            c.insertAfter("");
        }


    }

    public static void test06() throws Exception {
        CtClass cc = ClassPool.getDefault().get("testJavassist.Emp");
        Object[] all = cc.getAnnotations();
        Auther a = (Auther)all[0];
        String name = a.name();
        int year = a.year();
        System.out.println("name:" + name + ",year:" + year);
    }

    public static void main(String[] args) {
        try {
            test06();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
