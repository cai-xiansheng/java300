package MyPro04.cn.hz.oo2;

/**
 * @author 张辉
 * @Description test extends 构造继承父类的所有公共属性（不包括私有属性）
 * @create 2020-04-04 11:56
 */
public class TestExtends {

    public static void main(String[] args) {
//        Student stu = new Student();
        Student stu = new Student("zs",18,"计算机专业");

        stu.name="张辉";
        stu.height=18;
        stu.rest();

        // instanceof 是尽心类型判断的
        System.out.println(stu instanceof Student);
        System.out.println(stu instanceof Object);
        System.out.println(new Person() instanceof Student);

    }
}

class Person {
    String name;
    int height;

    public void rest() {
        System.out.println("休息一会儿！");
    }
}

class Student extends Person {
    String major;

    public void Study() {
        System.out.println("学习两小时！");
    }

    public Student(String name,int height,String major){
        this.name = name;
        this.height = height;
        this.major = major;
    }
}