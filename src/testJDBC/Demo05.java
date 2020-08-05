package testJDBC;

import java.sql.*;

/**
 * @author 张辉
 * @Description Batch批处理
 * @create 2020-07-31 13:33
 */
public class Demo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8", "root", "root");

            conn.setAutoCommit(false); // 设为手动提交
            long start = System.currentTimeMillis();

            st = conn.createStatement();

            for (int i = 0; i < 2000; i++) {
                st.addBatch("insert into t_user (tid, tname) values (" + i +", '张三" + i + "')");
            }

            st.executeBatch();

            conn.commit(); // 提交事务
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - start));


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
            if (st != null) {
                try {
                    st.close();
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
