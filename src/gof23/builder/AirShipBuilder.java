package gof23.builder;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 12:36
 */
public interface AirShipBuilder {
    Engine builderEngine();
    OrbitalModule builderOrbitalModule();
    EscapeTower builderEscapeTower();
}
