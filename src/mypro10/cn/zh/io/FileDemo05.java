package mypro10.cn.zh.io;

import java.io.File;

/**
 * @author 张辉
 * @Description 文件的长度
 * 文件状态下；length():字节数
 * @create 2020-04-19 21:35
 */
public class FileDemo05 {
    public static void main(String[] args) {
        File src = new File("F:/IDEA_project/Java300/src");
        System.out.println("长度：" + src.length());

        src = new File("F:/IDEA_project/Java300");
        System.out.println("长度:" + src.length() );
    }
}
