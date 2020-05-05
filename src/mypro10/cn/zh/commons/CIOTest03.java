package mypro10.cn.zh.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 张辉
 * @Description 读取文件
 * @create 2020-05-05 9:07
 */
public class CIOTest03 {
    public static void main(String[] args) throws IOException {
        // 读取文件
        String msg = FileUtils.readFileToString(new File("print.txt"),"UTF-8");
        System.out.println(msg);
        byte[] datas = FileUtils.readFileToByteArray(new File("print.txt"));
        System.out.println(datas.length);

        // 逐行读取msgs
        List<String> msgs = FileUtils.readLines(new File("print.txt"),"UTF-8");
        for (String string:msgs){
            System.out.println(string);
        }


        LineIterator it = FileUtils.lineIterator(new File("print.txt"),"UTF-8");
        while (it.hasNext()){
            System.out.println(it.nextLine());
        }
    }
}
