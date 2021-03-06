package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 张辉
 * @Description 测试mysql驱动，建立连接
 * @create 2020-07-31 13:33
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start = System.currentTimeMillis();
            // 建立连接(连接对象内部其实包含了Socket对象，是一个远程连接。比较耗时，这是Connection对象管理的一个要点！)
            // 真正开发中，为了提高效率，都会使用连接池来管理对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8", "root", "root");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println(end - start);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
