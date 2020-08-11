package sorm2.sorm.com.zh.bean;

/**
 * @author cai-xiansheng
 * @Description 封装了Java属性和get, set方法的源代码
 * @create 2020-08-10 14:18
 */
public class JavaFieldGetSet {
    /**
     * 属性的源码信息
     * instance: private int userId;
     */
    private String fieldInfo;
    /**
     * get方法的源码信息
     * instance: public int getUserId(){}
     */
    private String getInfo;
    /**
     * set方法的源码信息
     * instance: public void setUserId(int id){this.id = id;}
     */
    private String setInfo;

    @Override
    public String toString() {
        System.out.println(fieldInfo);
        System.out.println(getInfo);
        System.out.println(setInfo);
        return super.toString();
    }

    public JavaFieldGetSet() {
    }

    public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
        this.fieldInfo = fieldInfo;
        this.getInfo = getInfo;
        this.setInfo = setInfo;
    }

    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public String getGetInfo() {
        return getInfo;
    }

    public void setGetInfo(String getInfo) {
        this.getInfo = getInfo;
    }

    public String getSetInfo() {
        return setInfo;
    }

    public void setSetInfo(String setInfo) {
        this.setInfo = setInfo;
    }
}
