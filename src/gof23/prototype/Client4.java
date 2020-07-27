package gof23.prototype;

/**
 * @author 张辉
 * @Description 测试普通new方式创建对象和Clone方式创建对象的效率差异！
 * 如果需要短时间创建大量的对象，并且new的过程比较耗时，则可以考虑使用原型模式
 * @create 2020-07-27 10:40
 */
public class Client4 {

    public static void testNew(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Laptop t = new Laptop();
        }
        long end = System.currentTimeMillis();
        System.out.println("new的方式创建耗时：" + (end - start));
    }
    public static void testClone(int size)  {
        long start = System.currentTimeMillis();
        Laptop t = new Laptop();
        for (int i = 0; i < size; i++) {
            try {
                Laptop tmp = (Laptop) t.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Clone的方式创建耗时：" + (end - start));
    }

    public static void main(String[] args) {
        testNew(10);
        testClone(10);
    }
}

class Laptop implements Cloneable {
    public Laptop() {
        // 模拟创建对象耗时的过程
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}