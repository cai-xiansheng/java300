package gof23.flyWeight;

/**
 * @author 张辉
 * @Description 享元类
 * @create 2020-07-27 21:06
 */
public interface ChessFlyWeight {
    void setColor(String color);
    String getColor();
    void display(Coordinate c);
}

class ConcreteChess implements ChessFlyWeight {
    // 具体享元类ConcreteFlyWeight

    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子颜色：" + color);
        System.out.println("棋子位置：" + c.getX() + "---" + c.getY());
    }
}
