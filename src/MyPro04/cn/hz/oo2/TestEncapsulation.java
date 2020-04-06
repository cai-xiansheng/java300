package MyPro04.cn.hz.oo2;

/**
 * @author 张辉
 * @Description 测试封装
 * @create 2020-04-04 13:27
 */

/*
*     1. private 表示私有，只有自己类能访问
            只能在自己的类中使用，其他地方都不能使用
            * 使用范围：同一个类（一个类就是一个.java中的一个class）
      2. default表示没有修饰符修饰，只有同一个包的类能访问
            在变量或者方法没有被修饰的情况下默认为 default 的，这样就最大就只能在同一个包中使用
            * 使用范围：同一个类，同一个包(一个包就是package中)
      3. protected表示可以被同一个包的类以及其他包中的子类访问(好像不太经常使用)
            在被 protected 修饰的情况下，变量或者方法就最多被继承它的子类所使用。
            * 使用范围：同一个类，同一个包，它的子类(使用 extends 继承了它的子类，这儿的继承也就只能在同一个)
      4. public表示可以被该项目的所有包中的所有类访问
      *
      * 同一个 .java 中只能使用一个 public */


public class TestEncapsulation {
    public static void main(String[] args) {
        Human h = new Human();
//        h.age = 13;
        h.name = "zs";
        Test2Enapsulation p2 = new Test2Enapsulation();
        p2.setAge(13);
        System.out.println(p2.getAge());
    }
}

class Human {
    private int age;
    String name;
    protected int height;
    void sayAge(){
        System.out.println(age);
    }
}

class Boy extends Human{
    void sayHello(){
//        System.out.println(age);   子类无法使用父类的私有属性和方法
    }
}
