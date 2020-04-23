package algorithm;

/**
 * @author 张辉
 * @Description 算法第六次作业
 * @create 2020-04-21 21:26
 */
public class P240test {
    public static void main(String[] args) {
        //Qus1 q = new Qus1();
        //q.ss(120,0);
    }
}


class Qus4{
    StringBuilder str = new StringBuilder();

}


class Qus1{

    int max = 120;
    int sum = 0;
    int[][] arr = new int[][]{{60,0},{40,0},{30,0},{24,0},{20,0},{15,0},{12,0},{10,0},{8,0}};

    public Qus1(){}


    public void ss(int n,int index) {
        if (sum == max) {
            for (int i = 0; i < 9; i++) {
                if (arr[i][1] == 1) {
                    System.out.print(arr[i][0] + "+");
                }
            }
            System.out.println("=1");

            return;
        }


        for (int i = index; i < 9; i++) {
            if (arr[i][0] > n) {
                continue;
            }
            arr[i][1] = 1;
            sum += arr[i][0];
            ss(max-sum,i+1);
            arr[i][1] = 0;
        }


    }
}