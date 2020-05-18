package pers.wxp.pattern.singleton;

import pers.wxp.type.statictest.Singleton2;

/**
 * @author wuxiaopeng
 * @description:
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：易
 *
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 * @date 2020/3/20 13:54
 */
public class LazySafeSingleton {
    private static LazySafeSingleton instance;

    private LazySafeSingleton(){

    }

    public static synchronized LazySafeSingleton getInstance(){
        if (instance == null) {
            instance = new LazySafeSingleton();
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
