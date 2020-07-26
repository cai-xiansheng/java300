package gof23.builder;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 12:46
 */
public class ZhAirShipDirector implements AirShipDirector{

    public AirShipBuilder builder;

    public ZhAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine e = builder.builderEngine();
        OrbitalModule o = builder.builderOrbitalModule();
        EscapeTower et = builder.builderEscapeTower();

        // 装配成飞船
        AirShip ship = new AirShip();
        ship.setEngine(e);
        ship.setEscapeTower(et);
        ship.setOrbitalModule(o);

        return ship;
    }
}
