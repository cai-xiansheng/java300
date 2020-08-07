package testJDBC;

import java.io.*;
import java.sql.*;

/**
 * @author 张辉
 * @Description 测试使用JDBCUtils工具类来简化JDBC开发
 * @create 2020-07-31 13:33
 */
public class Demo11 {


    public static void main(String[] args) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getMysqlConn();
            ps = conn.prepareStatement("select * from t_user where id = ?");
            ps.setObject(1, 100);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, ps, conn);
        }
    }
}
