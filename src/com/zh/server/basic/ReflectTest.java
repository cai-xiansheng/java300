package com.zh.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 张辉
 * @Description 反射：把Java类中的各种结构（方法、属性、构造器、类名）映射称一个个的Java对象。
 * 1. 获取Class对象
 * 三种方式：Class.forName("完整路径")
 * 2. 动态创建对象
 * Class.forName("com.zh.server.basic.Iphone");
 * .getConstructor().newInstance();
 * @create 2020-06-07 11:09
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 三种方式
        // 1. 对象.getClass()
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();
        // 2. 类.class()
        clz = Iphone.class;
        // 3. Class.forname("包名.类名")
        Class clz1 = Class.forName("com.zh.server.basic.Iphone");

        // 创建对象
        //Iphone iphone1 = (Iphone) clz.newInstance();
        //System.out.println(iphone1);
        Iphone iphone1 = (Iphone)clz1.getConstructor().newInstance();
        System.out.println(iphone1);
    }
}

class Iphone{
    public Iphone() {

    }
}
