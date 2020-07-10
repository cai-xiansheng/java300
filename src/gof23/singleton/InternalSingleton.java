package gof23.singleton;

/**
 * @author 张辉
 * @Description 单例模式——静态内部类
 * 加载时不会初始化惊天变量INSTANCE，因为没有主动使用，达到lazy loading 的效果
 * @create 2020-07-10 21:32
 */
public class InternalSingleton {
    private static class SingletonHolder {
        private static final InternalSingleton INSTANCE = new InternalSingleton();
    }

    private InternalSingleton() {

    }

    public static InternalSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
