package testJDBC.testORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description 使用Object[] 来封装一条记录
 * 使用List<Object[]> 来存储多条记录
 * @create 2020-08-07 16:43
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where age = ?");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while (rs.next()) {
                //System.out.println(rs.getString("empname") + "---" + rs.getDouble(2) +"---" + rs.getInt(3));
                Object[] objs = new Object[3];
                objs[0] = rs.getObject(1);
                objs[1] = rs.getObject(2);
                objs[2] = rs.getObject(3);
                list.add(objs);
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }

        for (Object[] objs: list) {
            System.out.println(objs[0] + "---" + objs[1] + "---" + objs[2]);

        }
    }
}
