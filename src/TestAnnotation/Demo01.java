package TestAnnotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 张辉
 * @Description
 * @create 2020-06-27 8:56
 */
@SuppressWarnings(value = "all") // 取消警告
public class Demo01 {

    @Override // @Override注解
    public String toString() {
        return "";
    }

    @Deprecated // 被遗弃的，不推荐使用，但不是不让使用
    public static void test01() {

    }

    public static void test002() {
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        Date d = new Date();
        test01();
    }

}
