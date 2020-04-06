package MyPro07.cn.zh.arrays;

/**
 * @author 张辉
 * @Description 数组的三种初始化方式
 * @create 2020-04-05 0:07
 */
public class Test02 {
    public static void main(String[] args) {
//        静态初始化
        int[] a = {1,4,7};
        User[] b = {
                new User(1001,"zs"),
                new User(1002,"zed")
        };

//        默认初始化

        int[] c = new int[3]; // 默认给数组赋值，赋值的规则和成员变量默认赋值规则一致。


//        动态初始化

        int[] a1 = new int[2];//动态初始化数组，先分配空间；
        a1[0]=1;//给数组元素赋值；
        a1[1]=2;//给数组元素赋值；
    }
}
