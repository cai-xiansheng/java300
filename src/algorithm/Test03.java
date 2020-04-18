package algorithm;

import java.util.Arrays;

/**
 * @author 张辉
 * @Description
 * @create 2020-04-18 21:14
 */
public class Test03 {
    public static void main(String[] args) {
        //Hose h = new Hose();
        //System.out.println(Arrays.toString(h.horseGoods()));

        //Peach p = new Peach();
        //System.out.println(p.begin());

        //Three t = new Three();
        //t.sout();
        Queen q= new Queen();
        q.queen();
    }
}

class Queen {
    int[][] arry = new int[8][8];

    //int total = 0;
    public void queen() {
        findQueen(0);
    }

    public  void findQueen(int i){//寻找皇后节点
        if(i>7){//八皇后的解
            print();//打印八皇后的解
            return;
        }

        for(int m=0;m<8;m++){//深度回溯,递归算法
            if(check(i,m)){//检查皇后摆放是否合适
                arry[i][m]=1;
                findQueen(i+1);
                arry[i][m]=0;//清零，以免回溯的时候出现脏数据
            }
        }
    }

    public  boolean check(int k,int j){//判断节点是否合适
        for(int i=0;i<8;i++){//检查行列冲突
            if(arry[i][j]==1){
                return false;
            }
        }
        for(int i=k-1,m=j-1; i>=0 && m>=0; i--,m--){//检查左对角线
            if(arry[i][m]==1){
                return false;
            }
        }
        for(int i=k-1,m=j+1; i>=0 && m<=7; i--,m++){//检查右对角线
            if(arry[i][m]==1){
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < 8; i++) {
            Arrays.toString(arry[i]);
        }

    }
}

class Three {

    public void sout() {
        int[] result = new int[4];
        for (int i = 1000; i < 10000; i++) {
            int q = i;
            for (int j = 0; j < 4; j++) {
                result[j] = q % 10;
                q /= 10;
            }
            if (i % sum(result) == 0 && number(result)) {
                System.out.println(i);
            }
        }
    }

    private boolean number(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum * sum;
    }
}


class Peach {
    int day = 10;
    int last = 2;

    public int begin() {
        int sum = last;
        for (int i = 0; i < day - 1; i++) {
            sum += 2;
            sum *= 2;
        }
        return sum;
    }
}

class Hose {
    int horses = 100;
    int goods = 100;

    public int[] horseGoods() {
        int[] result = new int[3];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100 - i; j++) {
                for (int k = 0; k < 100 - j; k += 2) {
                    if (i + j + k == 100 && i * 3 + j * 2 + k / 2 == 100) {
                        result[0] = i;
                        result[1] = j;
                        result[2] = k;
                        return result;
                    }
                }
            }
        }

        return result;
    }
}