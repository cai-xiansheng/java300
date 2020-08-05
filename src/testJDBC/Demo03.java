package testJDBC;

import java.sql.*;

/**
 * @author 张辉
 * @Description 测试PreparedStatement的基本用法
 * @create 2020-07-31 13:33
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8", "root", "root");

            String sql = "insert into t_user (tid, tname) values (?, ?)"; // ?占位符

            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setInt(1, 1); // 参数索引从1开始算
            //ps.setString(2, "张三");

            ps.setObject(1, 2);
            ps.setObject(2, "李四");

            System.out.println("111");
            ps.execute();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
