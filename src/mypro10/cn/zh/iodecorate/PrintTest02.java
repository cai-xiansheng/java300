package mypro10.cn.zh.iodecorate;

import java.io.*;

/**
 * @author 张辉
 * @Description 打印流 PrintWriter
 * @create 2020-04-26 22:18
 */
public class PrintTest02 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
        pw.println("打印流");
        pw.println(true);
        pw.close();

    }
}
