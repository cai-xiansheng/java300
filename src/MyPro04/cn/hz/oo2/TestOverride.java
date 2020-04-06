package MyPro04.cn.hz.oo2;

/**
 * @author 张辉
 * @Description test override (overload 方法的重载，也就是使用统一方法名，然后因为不同的变量实现不同的功能)
 * override 既是重写也是覆盖的意思
 * @create 2020-04-04 12:15
 */
public class TestOverride {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.run();
        /*
        1.“==”： 方法名、形参列表相同。
        2.“≤”：返回值类型和声明异常类型，子类小于等于父类。
        3.“≥”： 访问权限，子类大于等于父类。
      */
    }
}

class Vehicle {
    public void run() {
        System.out.println("泡。。。");
    }

    public void stop() {
        System.out.println("停止！");
    }

    public Person whoIsPsg() {
        return new Person();
    }
}


class Horse extends Vehicle {
    public void run() {
        System.out.println("跑！");
    }

    public  Student whoIsPsg() { // 返回值类型小于等于父类
        return new Student("zs",19,"jisuanji");
    }
}
