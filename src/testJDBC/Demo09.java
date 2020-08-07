package testJDBC;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author 张辉
 * @Description 测试CLOB文本大对象的使用
 * 包含：将字符串、文本内容插入数据库中的ClOB字段值取出来的操作。
 * @create 2020-07-31 13:33
 */
public class Demo09 {


    public static void main(String[] args) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8", "root", "root");

            //ps = conn.prepareStatement("insert into t_user1 (username ,info) values (?, ?)");
            //ps.setObject(1,"撒");
            //ps.setClob(2,new FileReader(new File("d:/a.txt"))); // 将文本文件内容直接输入到数据库中
            //ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("safgsaga".getBytes())))); // 将程序中的字符串输入到数据库的CLOB字段中

            ps = conn.prepareStatement("select * from t_user1 where id = ?");
            ps.setObject(1, 2);

            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Clob clob = resultSet.getClob("info");
                Reader r = clob.getCharacterStream();
                int temp = 0;
                while ((temp = r.read()) != -1) {
                    System.out.print((char)temp);
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
