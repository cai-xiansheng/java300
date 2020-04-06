package MyPro04.cn.hz.oo2;

/**
 * @author 张辉
 * @Description test object
 * @create 2020-04-04 12:29
 */
public class TestObject {
    public static void main(String[] args) {
//        Object obj;
        TestObject to = new TestObject();
        System.out.println(to.toString());

        Person2 p2 = new Person2("zs",19);
        System.out.println(p2.toString());
    }

    public String toString() {
        return "测试重写toString";
    }
}


class Person2 {
    String name;
    int age;

    @Override
    public String toString() {
        return name + "年龄：" + age;
    }

    public Person2(String name,int age){
        this.name = name;
        this.age = age;
    }
}