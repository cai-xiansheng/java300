package javaExam.task03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张辉
 * @Description Task3的测试程序
 * @create 2020-07-02 22:59
 */
public class TestTask03 {
    public static void main(String[] args) {
        ArmedPolice armedPolice = new ArmedPolice(10034, "Jackie chan", 3000, "The 7th Brigade of the Armed Police", "The third Police supervisor");
        String day = "2004-4-1";
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = dateFormat1.parse(day);
            armedPolice.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int year = new Date().getYear() - armedPolice.getDate().getYear();
        int count = 2;
        for (int i = count; i < year; i += count) {
            armedPolice.Raise();
        }
        System.out.println(armedPolice.toString());
    }
}
