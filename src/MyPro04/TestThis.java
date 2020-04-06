package MyPro04;

/**
 * @author 张辉
 * @Description this use
 * @create 2020-04-03 22:46
 */
public class TestThis {
    int a;
    int b;
    int c;

    TestThis(int a,int b) {
        this.a = a;
        this.b = b;
    }

    TestThis(int a,int b ,int c){
        this(a, b);
        this.c = c;
    }

    void sing(){}

    void est(){
        this.sing();
        System.out.println("ahndkgawn");
    }

    public static void main(String[] args) {
        TestThis hi = new TestThis(2,3,4);
        hi.est();
    }
}
