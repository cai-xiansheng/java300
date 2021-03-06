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


            ps = conn.prepareStatement("insert into t_user (username, pwd, regTime, lastLoginTime) values (?, ?, ?, ?)");
            ps.setObject(1, "张三");
            ps.setObject(2, "123456");
            Date date = new java.sql.Date(System.currentTimeMillis());
            ps.setObject(3, date);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis()); // 如果需要插入指定日期，可以使用Calendar，DateFormat类
            ps.setObject(4, timestamp);

            ps.execute();

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
