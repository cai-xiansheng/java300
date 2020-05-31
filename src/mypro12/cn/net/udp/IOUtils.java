package mypro12.cn.net.udp;


import java.io.*;

/**
 * @author 张辉
 * @Description 图片字节数组的转换
 * 1. 图片读取到字节数组
 * 2. 字节数组写出到文件
 * @create 2020-04-25 18:13
 */
public class IOUtils {
    /**
     * 1. 图片读取到字节数组
     * 1.1 图片到程序 FileInputStream
     * 1.2 程序到字节数组 ByteArrayOutputStream
     *
     * @param filePath
     * @return byte[]
     */
    public static byte[] fileToByteArray(String filePath) {
        // 1. 创建源与目的地
        File src = new File(filePath);
        byte[] dest = null;
        // 2. 选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();

            // 3. 操作（读取）
            byte[] flush = new byte[1024 * 10];
            // 缓冲容器
            int len = -1;
            // 接收长度
            while ((len = is.read(flush)) != -1) {
                baos.write(flush, 0, len);
                // 写出到字节数组中
            }
            baos.flush();
            // 刷新，放置驻留
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 2. 字节数组写出到文件
     * 2.1 字节数组写出到程序 ByteArrayInputStream
     * 2.2 程序写出到文件 FileOutputStream
     *
     * @param src
     * @param filePath
     */
    public static void byteArrayToFile(byte[] src, String filePath) {
        // 1. 输出源
        File dest = new File(filePath);
        // 2. 选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            // 3. 操作（读取）
            byte[] flush = new byte[5];
            // 缓冲容器
            int len = -1;
            // 接收长度
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
                os.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
