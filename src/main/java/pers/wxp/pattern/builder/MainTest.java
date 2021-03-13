package pers.wxp.pattern.builder;

/**
 * 优点：用于对复杂对象封装，相同创建过程可以创建不同对象。
 * 缺点：需要大量封装类，系统过于庞大
 * @author wxp
 * @date 2021-3-12
 */
public class MainTest {
    public static void main(String[] args) {
        //第一步：引入创建者
        HouseBuilder houseBuilder = new HouseWu();
        //第二步：引入设计者
        HouseDesign houseDesign = new HouseDesign(houseBuilder);
        House house = houseDesign.make();
        System.out.println(house.getDoor());
        System.out.println(house.getFloor());
    }
}
