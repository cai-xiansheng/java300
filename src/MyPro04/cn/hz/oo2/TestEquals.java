package MyPro04.cn.hz.oo2;

/**
 * @author 张辉
 * @Description equals 和 == 的比较
 * @create 2020-04-04 12:45
 */
public class TestEquals {
    public static void main(String[] args) {
        User u1 = new User(1000, "高", "12414");
        User u2 = new User(1000, "zs", "12414");
        System.out.println(u1 == u2);
        System.out.println(u1.equals(u2));
        /*
        * ==判断是不是同一个对象
        * equals判断是否相等*/
    }
}

class User {
    int id;
    String name;
    String pwd;

    public User(int id, String naem, String pwd) {
        super();
        this.id = id;
        this.name = naem;
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
