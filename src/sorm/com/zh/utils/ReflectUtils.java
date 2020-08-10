package sorm.com.zh.utils;

import java.lang.reflect.Method;

/**
 * @author cai-xiansheng
 * @Description 封装了反射常用的操作
 * @create 2020-08-10 12:28
 */
public class ReflectUtils {

    /**
     * 调用Object对象对应属性fieldName的get方法
     * @param fieldName
     * @param object
     * @return
     */
    public static Object invokeGet(String fieldName, Object object) {
        try {
            Class clazz = object.getClass();
            Method method = clazz.getMethod("get" + StringUtils.firstChar2UpperCase(fieldName), null);
            return method.invoke(object, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
