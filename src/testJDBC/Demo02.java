package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 张辉
 * @Description 测试statement的基本用法，执行SQL语句，以及SQL注入问题
 * @create 2020-07-31 13:33
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接(连接对象内部其实包含了Socket对象，是一个远程连接。比较耗时，这是Connection对象管理的一个要点！)
            // 真正开发中，为了提高效率，都会使用连接池来管理对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8", "root", "root");

            Statement statement = conn.createStatement();

            //String name = "李四";
            //String sql = "insert into t_user (tid, tname) values (4, '" + name + "')";
            //boolean b = statement.execute(sql);
            //System.out.println(b);

            // 测试SQL注入
            String id = "5 or 1 = 1";
            String sql = "delete from t_user where tid = " + id;
            statement.execute(sql);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
