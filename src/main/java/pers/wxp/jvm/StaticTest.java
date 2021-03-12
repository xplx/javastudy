package pers.wxp.jvm;

/**
 * @author wxp
 * @date 2020-11-06
 */
public class StaticTest {
    static class Human {}
    static class Man extends Human {}
    static class Woman extends Human {}

    public void sayHello(Human human) {
        System.out.println("Hello guy!");
    }

    public void sayHello(Man man) {
        System.out.println("Hello man!");
    }

    public void sayHello(Woman woman) {
        System.out.println("Hello woman!");
    }

    public static void main(String[] args) {
        StaticTest staticDispatcher = new StaticTest();
        Human man = new Man();
        Human woman = new Woman();
        staticDispatcher.sayHello(man);
        staticDispatcher.sayHello(woman);
        staticDispatcher.sayHello((Man)man);
        staticDispatcher.sayHello((Woman)man);
    }
}
