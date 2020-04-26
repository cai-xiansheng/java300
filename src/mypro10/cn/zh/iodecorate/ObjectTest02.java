package mypro10.cn.zh.iodecorate;

import java.io.*;
import java.util.Date;

/**
 * @author 张辉
 * @Description 对象流
 * 1. 写出后读取
 * 2. 读取的顺序与写出的要一致
 * 3. 不是所有的对象都可以序列化 Serializable
 * @create 2020-04-26 21:40
 */
public class ObjectTest02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 写出（序列化：serialization）
        // 字符数组流不用关闭，（GC会自动处理，如果你提出了关闭，也只是一个建议而已）
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("abc.txt")));
        // 操作数据类型+数据
        oos.writeUTF("编码辛酸泪");
        oos.writeInt(18);
        oos.writeBoolean(false);
        oos.writeChar('a');
        // 对象
        oos.writeObject("水解其中味！");
        oos.writeObject(new Date());
        Employee emp = new Employee("mayun",400);
        oos.writeObject(emp);
        oos.flush();
        oos.close();
        // 读取（反序列化：Deserialization）
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("abc.txt")));
        // 顺序与写出一致
        String msg = ois.readUTF();
        int age = ois.readInt();
        boolean flag = ois.readBoolean();
        char ch = ois.readChar();
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object employee = ois.readObject();
        ois.close();

        if (str instanceof String) {
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if (date instanceof Date) {
            Date dataObj = (Date)date;
            System.out.println(dataObj);
        }
        if (employee instanceof Employee) {
            Employee empObj = (Employee)employee;
            System.out.println(empObj.getName() + "-->" + empObj.getSalary());
        }

        System.out.println(age);

    }
}
