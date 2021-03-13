package pers.wxp.pattern.builder;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author wxp
 * @date 2021-3-12
 * @descripe 设计者
 */
public class HouseDesign {
    private HouseBuilder houseBuilder;

    public HouseDesign(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House make(){
        houseBuilder.addFloors();
        houseBuilder.addDoor();
        return houseBuilder.getHouse();
    }
}
