package javaExam;

import java.util.Scanner;

/**
 * @author 张辉
 * @Description Task 1
 * @create 2020-07-02 22:06
 */
public class Sequence {
    private int[] datas;

    /**
     * Task 1 (1)
     */
    public void getData()
    {
        Scanner input = new Scanner(System.in);
        String[] line = input.nextLine().split(",");
        datas = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            datas[i] = Integer.parseInt(line[i]);
        }
    }

    /**
     * Task 1 (2)
     */
    public void reverse() {
        int left = 0, right = datas.length - 1;
        while (left < right) {
            int temp = datas[left];
            datas[left] = datas[right] ;
            datas[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Task 1 (3)
     */
    public void sort() {
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas.length - i - 1; j++) {
                if (datas[j] > datas[j + 1]) {
                    int temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Task 1 (3)
     */
    public double getAverage() {
        double sum = 0.0;
        for (int i = 0; i < datas.length; i++) {
            sum += datas[i];
        }
        return sum / datas.length;
    }

    /**
     * Task 1 (4)
     */
    public int getCloseToAverage() {
        int index = 0;
        double minLength = -1, average = getAverage();
        for (int i = 0; i < datas.length; i++) {
            double length = Math.abs(datas[i] - average);
            if (minLength < 0 || length < minLength) {
                minLength = length;
                index = i;
            }
        }
        return index;
    }

    /**
     * Task 1 (5)
     */
    public void show()
    {
        for (int i = 0; i < datas.length; i++) {
            System.out.printf("%d ", datas[i]);
        }
        System.out.println();
    }
}
