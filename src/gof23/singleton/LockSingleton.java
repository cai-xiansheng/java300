package gof23.singleton;

/**
 * @author 张辉
 * @Description 单例模式——双重校验锁
 * 不推荐使用
 * @create 2020-07-10 21:51
 */
public class LockSingleton {
    private volatile static LockSingleton instance;

    private LockSingleton() {

    }

    public static LockSingleton getInstance() {
        if (instance == null) {
            synchronized (LockSingleton.class) {
                if (instance == null) {
                    instance = new LockSingleton();
                }
            }
        }
        return instance;
    }

}
