package gof23.adapter;

/**
 * @author 张辉
 * @Description 客户端类：（相当于例子中的笔记本，只有USB接口）
 * @create 2020-07-27 11:13
 */
public class Client  {
    public void test1(Target t) {
        t.handleReq();
    }

    public static void main(String[] args) {
        Client c = new Client();

        Adaptee a = new Adaptee();

        //Target t = new Adapter();
        Target t = new Adapter2(a);

        c.test1(t);

    }
}
