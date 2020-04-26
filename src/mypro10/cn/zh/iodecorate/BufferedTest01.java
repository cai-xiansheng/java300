package mypro10.cn.zh.iodecorate;

import java.io.*;

/**
 * @author 张辉
 * @Description 分段读取文件字节输入流 加入缓冲流
 * 1. 创建流
 * 2. 选择流
 * 3. 操作
 * 4. 释放资源
 * @create 2020-04-26 19:04
 */
public class BufferedTest01 {
    public static void main(String[] args) {
        // 1. 创建流
        File src = new File("abc.txt");
        // 2. 选择流
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            // 3. 操作（分段读取）
            byte[] flush = new byte[1024];
            // 缓冲容器
            int len = -1;
            // 接收长度
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
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
    public static void test1(){
        // 1. 创建流
        File src = new File("abc.txt");
        // 2. 选择流
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            is = new FileInputStream(src);
            bis = new BufferedInputStream(is);
            // 3. 操作（分段读取）
            byte[] flush = new byte[1024];
            // 缓冲容器
            int len = -1;
            // 接收长度
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
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
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
