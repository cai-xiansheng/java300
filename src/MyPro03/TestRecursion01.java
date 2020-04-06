package MyPro03;

/**
 * @author 张辉
 * @Description 递归的调用
 * @create 2020-03-24 20:01
 */
public class TestRecursion01 {
    // 递归的调用就是自己调用自己
    // 递归必须有终止条件，不然会陷入无限循环
    public static void main(String[] args) {
        a();
    }

    static void a() {
        b();
        System.out.println("ad");
    }

    static void b() {
        System.out.println("ads");
    }
}
