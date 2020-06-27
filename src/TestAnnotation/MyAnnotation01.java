package TestAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 张辉
 * @Description 注解 @interface
 * 元注解：对注解作解释
 * @create 2020-06-27 9:46
 */
@Target(value = {ElementType.METHOD,ElementType.TYPE})
/**
 * 注解可以放在方法，类
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {

    String studentName() default "";
    int age() default 0;
    int id() default -1; // String indexOf("abc") -1
    String[] schools() default {"清华大学","北京邮电大学"};
}
