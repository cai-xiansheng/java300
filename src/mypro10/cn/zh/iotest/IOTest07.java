package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description IO标准步骤：字节数组输入流
 * 1. 创建源
 * 2. 选择流
 * 3. 操作
 * 4. 释放资源
 * @create 2020-04-25 17:32
 */
public class IOTest07 {

    public static void main(String[] args) {

        // 1. 创建源
        byte[] src = "talk is cheap show me the code".getBytes();
        // 2. 选择流
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(src);

            // 3. 操作（读取）
            byte[] flush = new byte[5];
            // 缓冲容器
            int len = -1;
            // 接收长度
            while ((len = is.read(flush)) != -1) {
                // 字节数组到字符串（解码）
                String str = new String(flush,0,len);
                System.out.println(str);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
