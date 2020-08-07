package testJDBC;

import java.io.*;
import java.sql.*;

/**
 * @author 张辉
 * @Description 测试BLOB二进制大对象的使用
 *
 * @create 2020-07-31 13:33
 */
public class Demo10 {


    public static void main(String[] args) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8", "root", "root");

            //ps = conn.prepareStatement("insert into t_user1 (username ,headImg) values (?, ?)");
            //ps.setObject(1,"撒");
            //ps.setBlob(2, new FileInputStream("d:/001.jpg"));
            //ps.execute();


            ps = conn.prepareStatement("select * from t_user1 where id = ?");
            ps.setObject(1, 3);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Blob b = resultSet.getBlob("headImg");
                InputStream is = b.getBinaryStream();


                OutputStream os = new FileOutputStream("d:/a.jpg");
                int temp = 0;
                while ((temp = is.read()) != -1) {
                    os.write(temp);
                }
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
