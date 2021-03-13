package pers.wxp.pattern.builder;

import org.springframework.security.access.method.P;

/**
 * @author lenovo
 * @date 2021-3-12
 */
public class HouseWu implements HouseBuilder{
    private House house = new House();
    @Override
    public void addFloors() {
        house.setDoor("吴-地板");
    }

    @Override
    public void addDoor() {
        house.setFloor("吴-门");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
