package testJDBC;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 张辉
 * @Description
 * @create 2020-08-07 15:45
 */
public class JDBCUtils {

    static Properties properties = null; // 可以帮助我们读取资源文件中的信息

    static {
        // 加载JDBCUtils类的时候调用
        properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties")); // 读取文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Connection getMysqlConn() {
        try {
            Class.forName(properties.getProperty("mysqlDriver"));
            return DriverManager.getConnection(properties.getProperty("mysqlURL"), properties.getProperty("mysqlUser"), properties.getProperty("mysqlPwd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement statement, Connection connection) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
