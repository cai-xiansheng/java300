package testJDBC.testORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张辉
 * @Description 使用Map 来封装一条记录
 * 使用List<Map> 来存储多条记录
 * @create 2020-08-07 16:43
 */
public class Demo02 {

    public static void test01() {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> list = new ArrayList<>();
        Map<String, Object> row = new HashMap<>(); // 使用一个Map封装一条记录
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id = ?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                //System.out.println(rs.getString("empname") + "---" + rs.getDouble(2) +"---" + rs.getInt(3));
                row.put("empname", rs.getObject(1));
                row.put("salary", rs.getObject(2));
                row.put("age", rs.getObject(3));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }

        // 遍历Map，就是遍历这一行的多列信息
        for (String key : row.keySet()) {
            System.out.print(key + "---" + row.get(key) + "\t");
        }

    }


    public static void test02() {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where age = ?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                //System.out.println(rs.getString("empname") + "---" + rs.getDouble(2) +"---" + rs.getInt(3));
                Map<String, Object> row = new HashMap<>(); // 使用一个Map封装一条记录
                row.put("empname", rs.getObject(1));
                row.put("salary", rs.getObject(2));
                row.put("age", rs.getObject(3));
                list.add(row);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }

        // 遍历Map，就是遍历这一行的多列信息
        for (Map<String, Object> row: list) {
            for (String key : row.keySet()) {
                System.out.print(key + "---" + row.get(key) + "\t");
            }
            System.out.println();
        }

    }


    public static void test03() {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Map<String, Object>> maps = new HashMap<>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where age = ?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                //System.out.println(rs.getString("empname") + "---" + rs.getDouble(2) +"---" + rs.getInt(3));
                Map<String, Object> row = new HashMap<>(); // 使用一个Map封装一条记录
                row.put("empname", rs.getObject(1));
                row.put("salary", rs.getObject(2));
                row.put("age", rs.getObject(3));
                maps.put(rs.getString(1), row);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }

        // 遍历Map，就是遍历这一行的多列信息
        for (String empname: maps.keySet()) {
            Map<String,Object> row = maps.get(empname);
            for (String key : row.keySet()) {
                System.out.print(key + "---" + row.get(key) + "\t");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        test03();
    }
}
