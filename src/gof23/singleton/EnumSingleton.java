package gof23.singleton;

/**
 * @author 张辉
 * @Description 单例模式——枚举模式
 * 能避免多线程同步的问题，没有延时加载
 * @create 2020-07-10 21:29
 */
public enum EnumSingleton {
    INSTANCE;

    public void doSomeThing() {

    }
}
