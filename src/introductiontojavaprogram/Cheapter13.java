package introductiontojavaprogram;

/**
 * @author 张辉
 * @Description
 * @create 2020-05-20 15:59
 */
public class Cheapter13 {
    public static void main(String[] args) {
        test_ComparableCircle();
    }
    public static void test_ComparableCircle(){
        ComparableCircle c1 = new ComparableCircle(10);
        ComparableCircle c2 = new ComparableCircle(8);
        System.out.println(c1.compareTo(c2));
    }
    public static void test_Square(){
        GeometricObject[] geometricObjects = new GeometricObject[5];
        geometricObjects[0] = new Square(true,10);
        geometricObjects[1] = new Square(false,20);
        geometricObjects[2] = new Square(false,30);
        geometricObjects[3] = new Square(true,40);
        geometricObjects[4] = new Square(true,50);
        for (int i = 0; i < 5; i++) {
            if (geometricObjects[i].filled)
        }
    }
}

interface Colorable{
    void howToColor();
}

class Square extends GeometricObject implements Colorable{

    private boolean isColorable;
    private double side;

    public double area(){
        return Math.pow(side,2);
    }

    public boolean isColorable() {
        return isColorable;
    }

    public Square(boolean isColorable, double side) {
        this.isColorable = isColorable;
        this.side = side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}

class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.pow(this.getRadius(), 2)*Math.PI;
    }
}

class ComparableCircle extends Circle implements Comparable {

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        ComparableCircle c = (ComparableCircle) o;
        if (this.area() > c.area()) {
            return 1;
        } else if (this.area() < c.area()) {
            return -1;
        } else {
            return 0;
        }
    }
}