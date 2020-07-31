package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-31 13:33
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
            System.out.println(conn);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
