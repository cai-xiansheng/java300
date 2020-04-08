package mypro06.cn.zh.exception;

/**
 * @author 张辉
 * @Description 运行异常的处理  RuntimeException
 * @create 2020-04-07 16:22
 */
public class Test01 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        if (a != 0) {
            System.out.println(b / a);
        }

        String str = null;
        if (str != null) {
            System.out.println(str.length());
        }

        Animal d = new Dog();
        if (d instanceof Cat) {
            // instanceof 用来判断是否是同一个类
            Cat c = (Cat)d;
        }

        // ArithmeticException 算数异常
        // NullPointerException 空指针异常
        // ClassCastException 类型转换异常
        // ArrayIndexOutOfBoundsException 数组下标越界异常
        // NumberFormatException 数字格式异常
    }
}


class Animal{

}
class Dog extends Animal{

}
class Cat extends Animal{

}