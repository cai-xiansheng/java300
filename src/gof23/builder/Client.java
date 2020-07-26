package gof23.builder;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 12:51
 */
public class Client {
    public static void main(String[] args) {
        AirShipDirector director = new ZhAirShipDirector(new ZhAirShipBuilder());

        AirShip ship = director.directAirShip();
        System.out.println(ship.getEngine().getName());
        ship.launch();
    }
}
