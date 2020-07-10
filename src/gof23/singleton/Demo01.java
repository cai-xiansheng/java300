package gof23.singleton;

/**
 * @author 张辉
 * @Description 测试五种单例模式
 * @create 2020-07-10 21:59
 */
public class Demo01 {
    public static void main(String[] args) {
        HungrySingleton s1 = HungrySingleton.getInstance();
        HungrySingleton s2 = HungrySingleton.getInstance();
        System.out.print("HungrySingleton:");
        System.out.println(s1 == s2);

        LazySingleton s3 = LazySingleton.getInstance();
        LazySingleton s4 = LazySingleton.getInstance();
        System.out.print("LazySingleton:");
        System.out.println(s3 == s4);

        InternalSingleton s5 = InternalSingleton.getInstance();
        InternalSingleton s6 = InternalSingleton.getInstance();
        System.out.print("LazySingleton:");
        System.out.println(s5 == s6);

        EnumSingleton s7 = EnumSingleton.INSTANCE;
        EnumSingleton s8 = EnumSingleton.INSTANCE;
        System.out.print("EnumSingleton:");
        System.out.println(s7 == s8);

        LockSingleton s9 = LockSingleton.getInstance();
        LockSingleton s10 = LockSingleton.getInstance();
        System.out.print("LockSingleton:");
        System.out.println(s9 == s10);
    }

}
