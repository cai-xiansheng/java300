package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description
 * @create 2020-04-25 20:43
 */
public class FileUtils {
    public static void main(String[] args) {
        // 文件到文件
        try {
            InputStream is = new FileInputStream("abc.txt");
            OutputStream os = new FileOutputStream("abc-copy.txt");
            copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 从文件到字节数组
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("01.png");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is,os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 从字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("01-copy.png");
            copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对接输入输出流
     * @param is
     * @param os
     */
    public static void copy(InputStream is, OutputStream os) {
        try {
            // 3. 操作
            byte[] flush = new byte[1024];
            // 缓冲容器
            int len = -1;
            // 接受长度：当输入流到了末尾是，会返回-1
            while ((len = is.read(flush)) != -1) {
                // 上边分段读取
                // 下边分段写入
                os.write(flush, 0, len);
            }
            os.flush();
            // 刷新，放置驻留
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(is,os);
        }

    }


    /**
     * 释放资源
     * @param is
     * @param os
     */
    public static void close(InputStream is, OutputStream os){
        // 4. 释放资源(分别关闭；先打开的后关闭)
        try {
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (os != null) {
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     * @param ios
     */
    public static void close(Closeable... ios){
        for (Closeable io:ios){
            try {
                if (io != null) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
