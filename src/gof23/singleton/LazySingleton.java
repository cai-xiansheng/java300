package gof23.singleton;

/**
 * @author 张辉
 * @Description 单例模式——懒汉模式
 * 常用的写法(lazy loading)
 * @create 2020-07-10 21:17
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
