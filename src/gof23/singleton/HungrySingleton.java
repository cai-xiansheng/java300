package gof23.singleton;

/**
 * @author 张辉
 * @Description 单例模式——饿汉模式
 * 没有达到lazy loading的效果
 * @create 2020-07-10 21:22
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}
