package mypro10.cn.zh.iodecorate;

import java.io.*;

/**
 * @author 张辉
 * @Description 转换流：InputStreamReader OutputStreamWriter
 * 1. 以字节流的形式操作字节流（处理纯文本）
 * 2. 指定字符集
 * @create 2020-04-26 20:42
 */
public class ConvertTest {
    public static void main(String[] args) {
        // 操作System.in 和System.out
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {
            // 循环获取键盘输入（exit退出），打印此内容
            String msg = "";
            while (!msg.equals("exit")) {
                msg = reader.readLine();
                // 循环读取
                writer.write(msg);
                // 循环写出
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
