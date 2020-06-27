package TestAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author 张辉
 * @Description 注解
 * @create 2020-06-27 10:03
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
public @interface MyAnnotation02 {
    String value();
}
