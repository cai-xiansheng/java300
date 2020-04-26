package mypro10.cn.zh.iodecorate;

import java.io.*;

/**
 * @author 张辉
 * @Description 纯文本拷贝
 * @create 2020-04-26 20:29
 */
public class CopyTxt {
    public static void main(String[] args) {
        copyTxt("abc.txt","dest.txt");
    }

    public static void copyTxt(String strPath,String destPath){
        // 1. 创建流
        File src = new File(strPath);
        //源头
        File dest = new File(destPath);
        // 目的地

        // 2. 选择流

        try (BufferedReader br = new BufferedReader((new FileReader(src)));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {

            String line = null;

            // 接受长度：当输入流到了末尾是，会返回-1
            while ((line=br.readLine())!=null) {
                bw.write(line);
                // 逐行写出
                bw.newLine();
            }
            bw.flush();
            // 刷新，放置驻留
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
