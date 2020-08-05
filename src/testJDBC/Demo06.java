package testJDBC;

import java.sql.*;

/**
 * @author 张辉
 * @Description 测试事物基本概念和用法
 * @create 2020-07-31 13:33
 */
public class Demo06 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8", "root", "root");

            conn.setAutoCommit(false); // JDBC 中默认自动提交事务


            String sql = "insert into t_user (tid, tname) values (?, ?)"; // ?占位符

            ps = conn.prepareStatement(sql);
            ps.setObject(1, 1);
            ps.setObject(2, "zhangSan");

            ps.execute();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            ps2 = conn.prepareStatement("insert into t_user (tid, tname) values (?, ?, ?)");
            ps2.setObject(1, 2);
            ps2.setObject(2, "zhangSan");

            ps2.execute();




            conn.commit();




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
