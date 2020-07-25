package gof23.singleton;

import java.io.Serializable;

/**
 * @author 张辉
 * @Description 单例模式——懒汉模式
 * 常用的写法(lazy loading)
 * 特点：延迟加载，懒加载！真正用的时候才加载！
 * 问题：资源利用效率高。但是每次调用的时候getInstance方法都需要同步，并发效率低。
 * @create 2020-07-10 21:17
 */
public class SingletonDemo06 implements Serializable {
    private static SingletonDemo06 instance;
    //类初始化时，不初始化这个对象（延时加载，真正用的时候才去创建）

    private SingletonDemo06() {
        if (instance != null) { // 用来防止反射
            throw new RuntimeException();
        }
    }

    public static synchronized SingletonDemo06 getInstance() {
        if(instance == null) {
            instance = new SingletonDemo06();
        }
        return instance;
    }
}
