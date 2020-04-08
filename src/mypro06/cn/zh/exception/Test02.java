package mypro06.cn.zh.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author 张辉
 * @Description (CheckedException 编译器异常) 使用try-catch捕获异常
 * @create 2020-04-07 16:46
 */
public class Test02 {
    public static void main(String[] args) {
        readMyFile();
    }
    public static void readMyFile(){
        FileReader reader = null;
        try {
            reader = new FileReader("d:/b.txt");
            char c1 = (char) reader.read();
            System.out.println(c1);
        } catch (FileNotFoundException e) {
            // 子类异常在父类异常前边
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
