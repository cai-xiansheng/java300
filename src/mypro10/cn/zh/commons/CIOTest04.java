package mypro10.cn.zh.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description 写出内容
 * @create 2020-05-05 9:15
 */
public class CIOTest04 {
    public static void main(String[] args) throws IOException {
        // 写出文件
        FileUtils.write(new File("happy.txt"),"danfkdsnafs\r\n","UTF-8",true);
        FileUtils.writeStringToFile(new File("happy.txt"),"danfkdsnafs","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("happy.txt"),"danfkdsnafs学习".getBytes(),true);

        // 写出文件
        List<String> datas = new ArrayList<String>();
        datas.add("码云");
        datas.add("马化腾");
        datas.add("弼马温");

        FileUtils.writeLines(new File("happy.txt"),datas,"-_______",true);
    }
}
