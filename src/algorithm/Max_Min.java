package algorithm;

/**
 * @author 张辉
 * @Description （9）利用分治法求一组数据中最大的两个数和最小的两个数
 * @create 2020-03-27 10:37
 */
public class Max_Min {
    static int[] ax(int[] array,int a,int b) {
        if(b-a < 2){
            int[] res = new int[2];
            res[0] = array[a]; // max
            res[1] = array[a]; // min
            if (res[0] > array[b])
            {
                res[1] = array[b];
            }else{
                res[0] = array[b];
            }
            return res;
        }else{
            int flag = (a+b)/2;
            int[] res = new int[2];
            int[] ar = new int[2];
            int[] br = new int[2];
            ar = ax(array,a,flag);
            br = ax(array,flag+1,b);
            res[0] = ar[0] < br[0] ? br[0] : ar[0]; // max
            res[1] = ar[1] > br[1] ? br[1] : ar[1]; // min
            return res;
        }

    }

    public static void main(String[] args) {
        int[] array = {1,9,2,0,4,5,6,7,10,14};
        int[] res = new int[2];
        res = ax(array,0,9);
        for (int i = 0;i < 2;i++){
            System.out.println(res[i]);
        }
    }
}
