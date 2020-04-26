package mypro10.cn.zh.iodecorate;

import java.io.*;

/**
 * @author 张辉
 * @Description 文件输出流  加入缓冲流
 * 1. 创建流
 * 2. 选择流
 * 3. 操作
 * 4. 释放资源
 * @create 2020-04-26 19:04
 */
public class BufferedTest02 {
    public static void main(String[] args) {
        //1. 创建流
        File dest = new File("dest.txt");

        //2. 选择流
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(dest));
            //3. 操作
            String msg = " i am great!";
            byte[] datas = msg.getBytes();
            // 字符串到字符数组（编码）
            os.write(datas,0,datas.length);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4. 释放资源
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
