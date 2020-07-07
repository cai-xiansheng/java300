package testReflection;

/**
 * @author 张辉
 * @Description 测试各种类型（class,interface,enum,annotation,primitive type,void）对应的java.lang.Class对象的获取方式
 * @create 2020-06-27 20:06
 */
@SuppressWarnings("all")
public class Demo01 {
    public static void main(String[] args) {
        String path = "testReflection.bean.User";

        try {
            Class<?> clazz = Class.forName(path);
            // 对象是表示或封装一些数据，一个类被加载后，JVM会创建一个对应的该类的Class对象，整个类的结构信息会放到对应的Class对象中。
            // 这个Class对象就像一面镜子一样，通过这面镜子我可以看到对应类的全部信息。
            System.out.println("clazz:" + clazz.hashCode());

            Class clazz2 = Class.forName(path); // 一个类只对应一个Class对象。
            System.out.println("clazz2:" + clazz2.hashCode());
            // 一个类只对应一个Class对象，上面的clazz和上面的Clazz2是一样的

            Class strClazz = String.class;  // 获取字符串类型的类
            Class strClazz2 = path.getClass(); // 这也是一种获取对象的方法
            // 上边两种获取string类型的对象，并且是一样的
            System.out.println(strClazz == strClazz2);
            System.out.println(strClazz.hashCode());
            System.out.println(strClazz2.hashCode());

            Class intClazz = int.class;

            // 根据数组获取对象
            int[] arr01 = new int[10];
            int[][] arr02 = new int[30][];
            int[] arr03 = new int[30];
            double[] arr04 = new double[10];
            // 数组对象的类型是否一样的，决定的元素是数组的维数是否一样，数组的类型也会对其有影响（也就是不同）！
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());
            System.out.println(arr03.getClass().hashCode());
            System.out.println(arr04.getClass().hashCode());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
