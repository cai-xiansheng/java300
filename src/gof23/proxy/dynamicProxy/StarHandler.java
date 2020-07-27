package gof23.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 11:58
 */
public class StarHandler implements InvocationHandler {

    private Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("真正的方法执行");
        System.out.println("面谈，签合同，等等");
        if (method.getName().equals("sing")) {
            object = method.invoke(realStar, args);
        }
        System.out.println("处理结束");
        return null;
    }
}
