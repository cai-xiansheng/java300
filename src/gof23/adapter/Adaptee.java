package gof23.adapter;

/**
 * @author 张辉
 * @Description 被适配的类，（相当于例子中的PS/2键盘）
 * @create 2020-07-27 11:12
 */
public class Adaptee {

    public void request() {
        System.out.println("可以完成用户需要的功能！");
    }
}
