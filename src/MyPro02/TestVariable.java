package MyPro02;

/**
 * @author 张辉
 * @Description 测试变量
 * @create 2020-03-20 21:26
 */
public class TestVariable {
    static  int size; // 静态变量，从属于类
    /*
    * 静态变量，使用static定义，从属于类，声明周期伴随类始终，从类加载到卸载。
    * 静态变量，类变量*/



    int a; // 成员变量，从属于对象
    /*
    * 成员变量可以不进行初始化，如果不初始化，系统会自动给成员变量初始化
    * 初始化规则如下
    * int       0
    * double    0.0
    * char      '\u0000'
    * boolean   false*/
    public static void main(String[] args) {
        int age;
        age = 18;
        int salary = 3000;
        int gao = 17;
        System.out.println(gao);
        /*
        * 局部变量，从属于方法
        *   就只能在自己的范围内（块内）使用
        *   局部变量必须初始化，不然不能使用*/
    }
}
