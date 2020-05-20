package mypro11.cn.zh.others;

import javax.swing.plaf.nimbus.State;
import java.sql.Time;

/**
 * @author 张辉
 * @Description 单例模式DCL
 * 单例模式：懒汉式套路的套路（介入并发），在多线程环境下，对外存在一个对象
 * 1. 构造器私有化--> 避免外部new构造器
 * 2. 提供私有的静态属性--> 存储对象的地址
 * 3. 提供公共的静态方法 --> 获取属性
 * double checking + volatile
 * @create 2020-05-14 11:21
 */
public class DoubleCheckedLocking {
    //2. 提供私有的静态属性
    private static volatile DoubleCheckedLocking instace;
    // 没有volatile其他线程可能访问一个没有初始化的对象，volatile可以防止指令重排

    //1. 构造器私有化
    private DoubleCheckedLocking() {

    }

    //3. 提供公共的静态方法
    public static DoubleCheckedLocking getInstace() {
        // double checking
        if (instace != null) {
            // 避免不必要的同步，已经存在对象
            return instace;
        }
        synchronized (DoubleCheckedLocking.class) {
            if (instace == null) {
                instace = new DoubleCheckedLocking();
                //1. 开辟空间 2. 初始化对象信息 3. 返回对象的地址给引用
            }
        }
        return instace;
    }

    //3. 提供公共的静态方法
    public static DoubleCheckedLocking getInstace1(long time) {

        if (instace == null) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instace = new DoubleCheckedLocking();
            //1. 开辟空间 2. 初始化对象信息 3. 返回对象的地址给引用
        }

        return instace;
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(DoubleCheckedLocking.getInstace());
        });
        t.start();
        System.out.println(DoubleCheckedLocking.getInstace());
    }

}
