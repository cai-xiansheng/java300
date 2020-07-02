package testReflection.bean;

/**
 * @author 张辉
 * @Description user bean
 * @create 2020-06-27 20:07
 */
public class User {
    private int id;
    private int age;
    private String uname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public User(int id, int age, String uname) {
        this.id = id;
        this.age = age;
        this.uname = uname;
    }

    // javabean必须有无参构造器
    public User() {

    }
}