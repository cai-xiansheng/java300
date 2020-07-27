package gof23.bridge;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 16:54
 */
public class Client {
    public static void main(String[] args) {
        // 销售联想笔记本电脑
        Computer2 c = new Laptop2(new Lenovo());

        c.sale();

        Computer2 c2 = new Desktop2(new Shenzhou());
        c2.sale();
    }
}
