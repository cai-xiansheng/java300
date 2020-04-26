package mypro10.cn.zh.iodecorate;

import java.io.*;

/**
 * @author 张辉
 * @Description Data数据流
 * 1. 写出后读取
 * 2. 读取的顺序与写出的保持一致
 * DataOutputStream
 * DataInputStream
 * @create 2020-04-26 21:17
 */
public class DataTest {
    public static void main(String[] args) throws IOException {
        // 写出
        ByteArrayOutputStream baos=  new ByteArrayOutputStream();
        // 字符数组流不用关闭，（GC会自动处理，如果你提出了关闭，也只是一个建议而已）
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        // 操作数据类型+数据
        dos.writeUTF("编码辛酸泪");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        // 读取
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        // 顺序与写出一致
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();

        System.out.println(age);
    }
}
