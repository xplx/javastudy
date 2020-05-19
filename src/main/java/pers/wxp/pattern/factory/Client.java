package pers.wxp.pattern.factory;

/**
 * @author wuxiaopeng
 * @description: 工厂是对对象构造、实例化、初始化过程的一种封装，
 * 以提供给其他需要对象的地方去使用，以降低耦合，提高系统的扩展性，重用性。
 * @date 2020/3/31 9:09
 */
public class Client {
    public static void main(String[] a) {
        Fruit f = Factory.getInstance("pers.wxp.pattern.factory.Apple");
        if (f != null) {
            f.eat();
        }
    }
}
