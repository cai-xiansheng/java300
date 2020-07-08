package testJavassist;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-07 21:00
 */
@Auther(name="Chiba",year=2005)
public class Emp {
    private int empno;
    private String ename;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Emp() {

    }

    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public void sayHello(int a) {
        System.out.println("sayHello," + a);
    }
}
