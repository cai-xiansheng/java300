package MyPro04.cn.hz.oo2;

/**
 * @author 张辉
 * @Description 继续测试类的封装
 * @create 2020-04-04 13:55
 */
public class Test2Enapsulation {
    private int id;
    private String name;
    private int age;
    private boolean man;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 140) {
            this.age = age;
        } else {
            System.out.println("请输入正常年龄：");
        }
    }

    public int getAge() {
        return this.age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }
}
