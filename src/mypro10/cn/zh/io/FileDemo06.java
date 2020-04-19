package mypro10.cn.zh.io;

import java.io.File;
import java.io.IOException;

/**
 * @author 张辉
 * @Description 文件创建删除操作
 * createNewFile() :不存在才创建，创建成功返回true
 * delete() :删除已经存在的文件
 * @create 2020-04-19 21:35
 */
public class FileDemo06 {
    public static void main(String[] args) throws IOException {
        File src = new File("F:/IDEA_project/Java300/io.txt");
        boolean flag =  src.createNewFile();
        System.out.println(flag);
        flag = src.delete();
        System.out.println(flag);

        // 不是文件夹
        src = new File("F:/IDEA_project/Java300/io");
        flag = src.createNewFile();
        System.out.println(flag);

        flag = src.delete();
        System.out.println(flag);

        // 补充：con con3……操作系统的设备名，不能正确创建
    }
}
