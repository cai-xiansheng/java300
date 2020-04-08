package mypro08.cn.zh.test;

import java.io.File;

/**
 * @author 张辉
 * @Description 使用递归算法打印目录树
 * @create 2020-04-07 15:55
 */
public class PrintFileTree {
    public static void main(String[] args) {
        File file = new File("F:\\wechat_development_item\\MINIProgram-school");

        printFile(file,0);
    }

    static  void printFile(File file,int level) {
        // 输出层数
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (File temp:files) {
                printFile(temp,level+1);
            }
        }
    }
}
