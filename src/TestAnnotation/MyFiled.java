package TestAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 张辉
 * @Description MyFiled注解
 * @create 2020-06-27 10:30
 */
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyFiled {
    String columnName();
    String type();
    int length();
}
