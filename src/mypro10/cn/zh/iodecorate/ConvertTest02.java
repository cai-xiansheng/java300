package mypro10.cn.zh.iodecorate;

import java.io.*;
import java.net.URL;

/**
 * @author 张辉
 * @Description 转换流：InputStreamReader OutputStreamWriter
 * 1. 以字节流的形式操作字节流（处理纯文本）
 * 2. 指定字符集
 * @create 2020-04-26 20:42
 */
public class ConvertTest02 {
    public static void main(String[] args) {
        // 操作网络流 下载百度的源代码
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new URL("http://www.baidu.com").openStream(),"UTF-8"));
             BufferedWriter writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream("beidu.html"),"UTF-8"));) {
            String msg = "";
            while ((msg = reader.readLine()) != null) {
                //System.out.println(msg);
                writer.write(msg);
                // 出现乱码，字符集不统一
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test02(){
        // 操作网络流 下载百度的源代码
        try (InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8");) {
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.print((char) temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test01(){
        // 操作网络流 下载百度的源代码
        try (InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8");) {
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.print((char) temp);
                // 出现乱码，字符数不够
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
