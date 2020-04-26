package mypro10.cn.zh.iodecorate;

import java.io.*;

/**
 * @author 张辉
 * @Description 打印流 PrintStream
 * 可以将内容打印到对应的文件中
 * @create 2020-04-26 22:18
 */
public class PrintTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);

        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
        ps.println("打印流");
        ps.println(true);
        ps.close();

        // 重定向输出端
        System.setOut(ps);
        System.out.println("change");

        // 重定向回控制台

        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("i am back...");
    }
}
