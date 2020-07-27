package gof23.flyWeight;

/**
 * @author 张辉
 * @Description 外部形态UnsharedConcreteFlyWeight
 * @create 2020-07-27 21:07
 */
public class Coordinate {
    private int x,y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
