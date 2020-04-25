package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description 文件拷贝：文件字节输入、输出流
 * 1. 创建流
 * 2. 选择流
 * 3. 操作（写出，写入）
 * 4. 释放资源
 * @create 2020-04-25 18:45
 */
public class Copy {
    public static void main(String[] args) {
        copy("src/mypro10/cn/zh/iotest/IOTest01.java", "dest.txt");
        //File src = new File("dest.txt");
        //boolean b = src.delete();
        //System.out.println(b);
    }

    /**
     * 文件的拷贝
     *
     * @param strPath
     * @param destPath
     */
    public static void copy(String strPath, String destPath) {
        // 1. 创建流
        File src = new File(strPath);
        //源头
        File dest = new File(destPath);
        // 目的地

        // 2. 选择流

        try (InputStream is = new FileInputStream(src);
             OutputStream os = new FileOutputStream(dest)) {

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
        }

    }
}
