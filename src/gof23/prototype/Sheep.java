package gof23.prototype;

import java.util.Date;

/**
 * @author 张辉
 * @Description 原型模式
 * @create 2020-07-26 13:10
 */
public class Sheep implements Cloneable{
    // 克隆
    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); // 直接调用Object 对象的克隆方法（clone()）

        // 添加如下代码，实现深克隆
        Sheep s = (Sheep) obj;
        s.birthday = (Date) this.birthday.clone(); // 把属性也进行克隆！

        return obj;
    }

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
