package mypro10.cn.zh.iodecorate;

import java.io.*;

/**
 * @author 张辉
 * @Description 文件字节输出流
 * 1. 创建源
 * 2. 选择流
 * 3. 操作（写出内容）
 * 4. 释放资源
 * @create 2020-04-26 20:03
 */
public class BufferedTest04 {
    public static void main(String[] args) {
        //1. 创建流
        File dest = new File("dest.txt");
        //2. 选择流
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            //3. 操作
            //String msg = "我说的话你必须听！";
            //writer.write(msg,0,msg.length());
            //writer.flush();

            writer.append("IO is so easy");
            writer.newLine();
            writer.append("陕西省");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
