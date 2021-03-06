package gof23.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 张辉
 * @Description 原型模式（浅复制）
 * @create 2020-07-26 13:10
 */
public class Sheep implements Cloneable, Serializable {
    // 序列化和反序列化必须实现Serializable接口，实现复制必须有Cloneable接口

    // 克隆
    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); // 直接调用Object 对象的克隆方法（clone()）

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
