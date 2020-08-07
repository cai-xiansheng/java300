package testJDBC;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author 张辉
 * @Description 测试时间处理（java.sql.Date,Time,Timestamp）,取出指定时间段的数据
 * @create 2020-07-31 13:33
 */
public class Demo08 {

    /**
     * 将字符串代表的日期转为long类型的数字（格式：yyyy-MM-dd hh:mm:ss）
     *
     * @param dateStr
     * @return
     */
    public static long str2Date(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8", "root", "root");

            ps = conn.prepareStatement("select * from t_user where lastLoginTime > ? and lastLoginTime < ? order by lastLoginTime");

            Date start = new Date(str2Date("2020-07-17 19:52:02"));
            Date end = new Date(str2Date("2020-07-24 11:39:24"));
            ps.setDate(1, start);
            ps.setDate(2, end);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "--" + resultSet.getString("username") + "---" + resultSet.getTimestamp("lastLoginTime"));
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
