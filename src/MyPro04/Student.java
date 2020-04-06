package MyPro04;

/**
 * @author 张辉
 * @Description 类的构造
 * @create 2020-03-24 20:33
 */
public class Student {
    // 属性fields
    int id;
    String name;
    int age;

    Computer comp;

    void study() {
        System.out.println("我在学习！" + comp.brand);
    }

    void play() {
        System.out.println("我在玩游戏！");
    }

    //构造方法，用于创建这个类的对象，无参的构造方法可以由系统自动创建。
    Student() {
    }

    //程序执行的入口，必须要有
    public static void main(String[] args) {
        Student stu = new Student(); // 创建一个对象
        //这儿创建的对象就是前边的构造方法，用来创建这个类的对象。现时使用中可以省略不写
        stu.id = 1001;
        stu.name = "zhanghui";
        stu.age = 18;
        Computer c1 = new Computer();
        c1.brand = "联想";

        stu.comp = c1;

        stu.study();
        stu.play();
    }
}


class Computer {
    String brand;
}