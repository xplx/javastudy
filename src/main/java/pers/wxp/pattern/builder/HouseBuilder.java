package pers.wxp.pattern.builder;

/**
 * @author wxp
 * @date 2021-3-2 wxp
 */
public interface HouseBuilder {
    /**
     * 添加地板
     */
    void addFloors();

    /**
     * 添加门
     */
    void addDoor();

    House getHouse();
}
