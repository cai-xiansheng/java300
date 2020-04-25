package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description 文件字节输出流
 * 1. 创建源
 * 2. 选择流
 * 3. 操作（写出内容）
 * 4. 释放资源
 * @create 2020-04-25 18:13
 */
public class IOTest04 {
    public static void main(String[] args) {
        // 1. 创建流
        File dest = new File("dest.txt");
        // 2. 选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest,true);
            // 3. 操作
            String msg = "I am anglue\t";
            byte[] datas = msg.getBytes();
            // 字符串到字节数组（编码）
            os.write(datas,0,datas.length);
            os.flush();
            // 刷新，放置驻留
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            try {
                if (os!=null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



        // 1. 创建流
        File dest1 = new File("dest.txt");
        // 2. 选择流
        OutputStream os1 = null;
        try {
            os1 = new FileOutputStream(dest1,true);

            // 3. 操作（输出）
            String msg = "wo shi ni baba!\n";
            byte[] datas = msg.getBytes();
            os1.write(datas,0,datas.length);
            os1.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 4. 释放资源
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // 1. 创建流
        File dest2 = new File("dest.txt");
        // 2. 选择流
        OutputStream os2 = null;
        try {
            os2 = new FileOutputStream("dest.txt",true);

            // 3. 操作（输出）
            String msg = "hha hah ，第三遍！\t";
            byte[] datas = msg.getBytes();
            os2.write(datas,0,datas.length);
            os2.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 4. 释放资源（关闭流）
            try {
                if (os2 != null) {
                    os2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
