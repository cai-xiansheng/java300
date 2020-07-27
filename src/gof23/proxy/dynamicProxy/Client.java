package gof23.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 12:00
 */
public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);

        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class}, handler);

        proxy.sing();
    }
}
