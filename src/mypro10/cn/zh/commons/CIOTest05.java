package mypro10.cn.zh.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author 张辉
 * @Description 拷贝
 * @create 2020-05-05 13:40
 */
public class CIOTest05 {
    public static void main(String[] args) throws IOException {
        // 复制文件
        //FileUtils.copyFile(new File("p.png"),new File("p-copy.png"));
        // 复制文件到目录
        //FileUtils.copyFileToDirectory(new File("p.png"),new File("lib"));
        // 复制目录到目录（是将当前src目录拷贝到目标目录并且称为dest目录的子目录）
        //FileUtils.copyDirectoryToDirectory(new File("lib"),new File("lib2"));
        // 复制目录（这是直接复制的）
        //FileUtils.copyDirectory(new File("lib"),new File("lib2"));
        // 拷贝URL内容
        //String URL = "https://img.zcool.cn/community/0128be58d20fc3a801219c77e6ff8e.jpg@1280w_1l_2o_100sh.jpg";
        //FileUtils.copyURLToFile(new URL(URL),new File("marvel.jpg"));

        //读取URL内容到字符串（百度是UTF-8，163是GBK）
        //String datas = IOUtils.toString(new URL("https://www.163.com"),"GBK");
        //System.out.println(datas);
    }
}
