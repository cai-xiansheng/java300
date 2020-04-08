package mypro06.cn.zh.exception;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author 张辉
 * @Description 使用throw抛出异常
 * @create 2020-04-07 17:00
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        readMyFile();
        // main抛出给 JRM
    }

    public static void readMyFile() throws IOException {
        FileReader reader = null;

        reader = new FileReader("d:/b.txt");
        char c1 = (char) reader.read();
        System.out.println(c1);

        if (reader != null) {
            reader.close();
        }

    }
}
