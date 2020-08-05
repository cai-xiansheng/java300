package testJDBC;

import java.sql.*;

/**
 * @author 张辉
 * @Description 测试ResultSet结果集
 * @create 2020-07-31 13:33
 */
public class Demo04 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8", "root", "root");

            String sql = "select * from t_user where tid > ?"; // ?占位符

            ps = conn.prepareStatement(sql);
            ps.setObject(1, 1);

             resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "---" + resultSet.getString(2));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
