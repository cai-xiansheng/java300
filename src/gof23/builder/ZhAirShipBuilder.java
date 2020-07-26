package gof23.builder;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 12:39
 */
public class ZhAirShipBuilder implements AirShipBuilder{
    // StringBuilder，以后学习的XML解析，JDOM库中的类：DomBuilder，SaxBuilder ，都是建造者模式

    @Override
    public Engine builderEngine() {
        System.out.println("构建Zh牌发动机！");
        return new Engine("Zh牌发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("构建Zh牌轨道舱！");
        return new OrbitalModule("Zh牌轨道舱");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建Zh牌逃逸塔！");
        return new EscapeTower("Zh牌逃逸塔");
    }

}
