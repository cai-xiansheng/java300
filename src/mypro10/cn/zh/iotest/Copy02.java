package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description 文件字节输入\输出流
 * 1. 创建源
 * 2. 选择流
 * 3. 操作（写出内容）
 * 4. 释放资源
 * @create 2020-04-25 18:13
 */
public class Copy02 {
    public static void main(String[] args) {
        // 1. 创建流
        File src = new File("abc.txt");
        File dest = new File("dest.txt");
        // 2. 选择流
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(src);
            writer = new FileWriter(dest);
            // 3. 操作
            // 写法一
            //String msg = "I am anglue\t嘀哒哒";
            //char[] datas = msg.toCharArray();
            // 字符串到字符数组（编码）
            //writer.write(datas,0,datas.length);
            //writer.flush();
            // 刷新，放置驻留

            // 写法二
            //String msg = "I am anglue\t嘀哒哒";
            //writer.write(msg,0,msg.length());
            //weiter.write("~~~~~~~~~");
            //writer.flush();

            // 写法三
            // writer.append().append();
            char[] flush = new char[1024];
            int len = -1;
            while ((len = reader.read(flush)) != -1) {
                writer.write(flush,0,len);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源(分别关闭；先打开的后关闭)
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
