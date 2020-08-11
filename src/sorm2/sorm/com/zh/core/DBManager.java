package sorm2.sorm.com.zh.core;

import sorm2.sorm.com.zh.bean.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author cai-xiansheng
 * @Description 根据配置信息，维持连接对象的管理（增加连接池功能）
 * @create 2020-08-10 12:25
 */
public class DBManager {
    private static Configuration configuration;

    static {
        // 静态代码块
        Properties properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("sorm/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration = new Configuration();
        configuration.setDriver(properties.getProperty("driver"));
        configuration.setPoPackage(properties.getProperty("poPackage"));
        configuration.setPwd(properties.getProperty("pwd"));
        configuration.setSrcPath(properties.getProperty("srcPath"));
        configuration.setUrl(properties.getProperty("url"));
        configuration.setUser(properties.getProperty("user"));
        configuration.setUsingDB(properties.getProperty("usingDB"));
    }

    public static Connection getConnection() {
        try {
            Class.forName(configuration.getDriver());
            return DriverManager.getConnection(configuration.getUrl(),
                    configuration.getUser(), configuration.getPwd()); // 直接建立连接，后期添加连接池处理，提高连接效率!
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(Statement statement, Connection connection) {
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static Configuration getConfiguration() {
        if (configuration == null) {
            return null;
        }
        return configuration;
    }


}
