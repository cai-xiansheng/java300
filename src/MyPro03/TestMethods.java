package MyPro03;

/**
 * @author 张辉
 * @Description 测试方法的基本使用
 * @create 2020-03-24 19:43
 */
public class TestMethods {
    // 基本类型传递的是该数据的copy值。
    // 引用类型传递的是对象引用的copy值，但指向的是同一个对象。

    // 方法的重载，实际是完全不相同的，方法名相同，参数的个数不相同，构成参数的重载。
    // 方法的重载，也有可能是参数的类型不同，而方法名和参数的个数也构成重载。
    public static void main(String[] args) {
        // 通过对象调用普通方法
        TestMethods tm = new TestMethods();
        tm.printSxt();
        tm.add(4, 5, 6);
        System.out.println('q' + tm.add(4, 5, 6));
    }

    void printSxt() {
        System.out.println("124");
        System.out.println("319035u");
    }

    int add(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println(sum);
        return sum; // return 两个作用：1. 结束方法的运行。2. 返回值
    }
}
