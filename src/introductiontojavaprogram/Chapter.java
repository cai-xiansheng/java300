package introductiontojavaprogram;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;


/**
 * @author 张辉
 * @Description 第十二章实验
 * @create 2020-05-20 11:37
 */
public class Chapter {
    public static void main(String[] args) {
        //1. 创建流
        File f = new File("Exercise12_15.txt");
        if (!f.exists()) {
            // 文件不存在
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件创建失败！");
                return;
            }
        }
        // 缓冲流输出
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));){
            for (int i = 0; i < 100; i++) {
                bufferedWriter.write((int) (Math.random()*100) + " ");
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 缓冲流输入
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f));){
            char[] flush = new char[1024 * 8];
            int len = bufferedReader.read(flush);
            String s = new String(flush,0,len);
            String[] str = s.split(" ");
            int[] num = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                num[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(num);
            System.out.println(Arrays.toString(num));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    boolean flag = true;
    //    while (flag) {
    //        System.out.println("请输入两个整数(例：1 2)：");
    //        int a = 0;
    //        int b = 0;
    //        try {
    //            a = sc.nextInt();
    //            b = sc.nextInt();
    //            System.out.println("a + b = " + a + b);
    //        } catch (InputMismatchException e) {
    //            System.out.println("输入的数字有误，请重新输入！");
    //            sc.nextLine(); // 作用：清空输入。
    //        }
    //    }
    //    sc.close();
    //}
}


