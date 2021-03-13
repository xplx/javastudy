package pers.wxp.pattern.builder;

/**
 * @author lenovo
 * @date 2021-3-12
 */
public class HouseZhang implements HouseBuilder{
    private House house = new House();
    @Override
    public void addFloors() {
        house.setFloor("张-地板");
    }

    @Override
    public void addDoor() {
        house.setDoor("张-门");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
