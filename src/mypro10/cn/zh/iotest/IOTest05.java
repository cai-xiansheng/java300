package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description 文件字符输入流
 * 1. 创建源
 * 2. 选择流
 * 3. 操作
 * 4. 释放资源
 * @create 2020-04-25 17:32
 */
public class IOTest05 {

    public static void main(String[] args) {

        // 1. 创建源
        File src = new File("abc.txt");
        // 2. 选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);

            // 3. 操作（读取）
            char[] flush = new char[1024];
            // 缓冲容器
            int len = -1;
            // 接收长度
            while ((len = reader.read(flush)) != -1) {
                // 字符数组到字符串
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
