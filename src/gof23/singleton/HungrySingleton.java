package gof23.singleton;

/**
 * @author 张辉
 * @Description 单例模式——饿汉模式
 * 没有达到lazy loading的效果
 * 特点：线程安全、调用效率高
 * @create 2020-07-10 21:22
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    // 类初始化时，立即加载这个对象！加载类时，天然时线程安全的。

    private HungrySingleton() {

    }

    // 方法没有同步，调用效率高
    public static HungrySingleton getInstance() {
        return instance;
    }

}
