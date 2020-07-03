package javaExam.task02;

import java.io.*;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-03 15:32
 */
public class Task02B {
    public static void main(String[] args) {
        String path = "out.txt";
        File src = new File(path);
        if (src == null || !src.exists()) {
            System.out.println("文件不存在");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(src))){
                boolean flag = src.createNewFile();
                for (int i = 0; i < 100; i++) {
                    double x = Math.random() * 100;
                    double y = Math.random() * 100;
                    String str = x + "";
                    int op = (int) Math.floor(Math.random() * 4);
                    switch (op) {
                        case 0:
                            str = str + "+";
                            break;
                        case 1:
                            str = str + "-";
                            break;
                        case 2:
                            str = str + "*";
                            break;
                        case 3:
                            str = str + "\\";
                            break;
                        default:
                    }
                    str = str + y;
                    ArithmeticExpression a = new ArithmeticExpression(str);
                    double result = a.getResult();
                    String res = str + "=" + result + "\n";
                    bw.write(res,0,res.length());
                }
                bw.flush();
            } catch (IOException e) {
                System.out.println("文件创建失败");
            }
            if (src.length() != 0) {
                System.out.println("随机生成成功！");
            }
        } else {
            System.out.println("文件存在");
            try (BufferedReader br = new BufferedReader(new FileReader(src));){
                String line = null;

                // 接受长度：当输入流到了末尾是，会返回-1
                while ((line = br.readLine())!=null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}