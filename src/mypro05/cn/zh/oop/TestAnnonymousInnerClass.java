package mypro05.cn.zh.oop;

/**
 * @author 张辉
 * @Description 测试匿名内部类
 * @create 2020-04-06 16:35
 */
public class TestAnnonymousInnerClass {

    public static void test01(A a){
        System.out.println("ajd");
        a.aa();
    }

    public static void main(String[] args) {
        TestAnnonymousInnerClass.test01(new A() {
            @Override
            public void aa() {
                System.out.println("Test");
            }
        });
    }
}

interface A{
    void aa();
}