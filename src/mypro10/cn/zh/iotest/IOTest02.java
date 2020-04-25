package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description IO标准步骤（完善版）
 * 1. 创建源
 * 2. 选择流
 * 3. 操作
 * 4. 释放资源
 * @create 2020-04-25 17:32
 */
public class IOTest02 {

    public static void main(String[] args) {

        // 1. 创建源
        File src = new File("abc.txt");
        // 2. 选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);

            // 3. 操作（读取）
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.println((char) temp);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

        // 1. 创建流
        File src1 = new File("abc.txt");
        // 2. 选择流
        InputStream is1 = null;
        try {
            is1 = new FileInputStream(src);

            // 3. 操作流
            int temp;
            while ((temp = is1.read()) != -1) {
                System.out.println((char) temp);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if (is1 != null) {
                    is1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // 1. 创建流
        File src2 = new File("abc.txt");
        // 2. 选择流
        InputStream is2 = null;
        try {
            is2 = new FileInputStream(src2);
            // 3. 操作流
            int temp;
            while ((temp = is2.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (is2 != null) {
                    is2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
