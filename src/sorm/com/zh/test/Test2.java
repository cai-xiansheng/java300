package sorm.com.zh.test;

import sorm.com.zh.core.Query;
import sorm.com.zh.core.QueryFactory;
import sorm.com.zh.vo.EmpVO;

import java.util.List;

/**
 * @author cai-xiansheng
 * @Description 测试连接池的调用
 * @create 2020-08-11 18:28
 */
public class Test2 {

    public static void test01() {
        Query query = QueryFactory.createQuery();
        String sql2 = "select e.id,e.empname,e.salary + e.bonus salary,age,d.dname deptName,d.address deptAddr " +
                "from emp e join dept d on e.deptId = d.id;";
        List<EmpVO> list2 = query.queryRows(sql2, EmpVO.class, null);
        for (EmpVO emp : list2) {
            System.out.println(emp.getEmpname() + "----" + emp.getAge() + "---" + emp.getSalary());
        }
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            test01();
        }
        long b = System.currentTimeMillis();
        System.out.println((b-a));
    }
}
