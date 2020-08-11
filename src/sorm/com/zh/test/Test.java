package sorm.com.zh.test;

import sorm.com.zh.core.Query;
import sorm.com.zh.core.QueryFactory;
import sorm.com.zh.vo.EmpVO;

import java.util.List;

/**
 * @author cai-xiansheng
 * @Description 客户端调用的测试类
 * @create 2020-08-11 17:30
 */
public class Test {
    public static void main(String[] args) {
        Query query = QueryFactory.createQuery();
        String sql2 = "select e.id,e.empname,e.salary + e.bonus salary,age,d.dname deptName,d.address deptAddr " +
                "from emp e join dept d on e.deptId = d.id;";
        List<EmpVO> list2 = query.queryRows(sql2, EmpVO.class, null);
        for (EmpVO emp : list2) {
            System.out.println(emp.getEmpname() + "----" + emp.getAge() + "---" + emp.getSalary());
        }
    }
}
