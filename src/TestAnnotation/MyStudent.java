package TestAnnotation;

/**
 * @author 张辉
 * @Description
 * @create 2020-06-27 10:15
 */
@MyTable(value = "tb_student")
public class MyStudent {
    @MyFiled(columnName = "id",type = "int",length = 3)
    private int id;

    @MyFiled(columnName = "sname",type = "varchar",length = 10)
    private String studentName;

    @MyFiled(columnName = "age",type = "int",length = 10)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
