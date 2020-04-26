package mypro10.cn.zh.iodecorate;

import java.io.*;

/**
 * @author 张辉
 * @Description 文件字符输入流 加入缓冲流
 * 1. 创建源
 * 2. 选择流
 * 3. 操作
 * 4. 释放资源
 * @create 2020-04-26 20:03
 */
public class BufferedTest03 {
    public static void main(String[] args) {
        //1. 创建源
        File src = new File("abc.txt");
        //2. 选择流
        try(BufferedReader reader = new BufferedReader(new FileReader(src))) {
            //3. 操作
            String line = null;
            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
