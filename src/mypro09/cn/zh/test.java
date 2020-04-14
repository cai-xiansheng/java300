package mypro09.cn.zh;

/**
 * @author 张辉
 * @Description
 * @create 2020-04-14 14:39
 */
public class test {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s instanceof Student);
        System.out.println(s instanceof Person);
    }
}

class Person{
    int age;
}

class Student extends Person{
    int name;
}
