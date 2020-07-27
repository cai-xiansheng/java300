package gof23.Decorator;

import java.io.*;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 18:04
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        System.out.println("增加新的飞行功能:");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        System.out.println("增加新水里游泳功能：");
        WaterCar waterCar = new WaterCar(car);
        waterCar.move();

        System.out.println("增加两个新的功能：飞、游----");
        WaterCar waterCar1 = new WaterCar(new FlyCar(car));
        waterCar1.move();

        try {
            Reader r = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:a.txt"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
