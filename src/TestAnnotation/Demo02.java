package TestAnnotation;

/**
 * @author 张辉
 * @Description
 * @create 2020-06-27 9:49
 */
public class Demo02 {

    @MyAnnotation01(age = 19,studentName = "老高",id = 1001,schools = {"清华大学","北京邮电大学"})
    public void test() {

    }

    @MyAnnotation02(value = "said")
    public void test02() {

    }

}
