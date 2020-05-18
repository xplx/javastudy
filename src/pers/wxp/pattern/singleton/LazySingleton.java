package pers.wxp.pattern.singleton;

import lombok.SneakyThrows;

/**
 * @author wuxiaopeng
 * @description:
 * 是否 Lazy 初始化：是
 * 是否多线程安全：否
 * 实现难度：易
 *
 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 * @date 2020/3/20 13:34
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("开始");
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //多线程情况下，该单列模式是不安全的
                    System.out.println(getInstance());
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();
        }
        System.out.println("结束");
    }
}
