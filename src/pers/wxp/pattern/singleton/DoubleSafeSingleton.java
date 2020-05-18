package pers.wxp.pattern.singleton;

/**
 * @author wuxiaopeng
 * @description: 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * <p>
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 * @date 2020/3/20 13:54
 */
public class DoubleSafeSingleton {
    /**
     * volatile关键字的一个作用是禁止指令重排，把instance声明为volatile之后，对它的写操作就会有一个内存屏障（什么是内存屏障？）
     */
    private volatile static DoubleSafeSingleton instance;

    private DoubleSafeSingleton() {

    }

    public static synchronized DoubleSafeSingleton getInstance() {
        if (null == instance) {
            synchronized (DoubleSafeSingleton.class) {
                if (instance == null) {
                    instance = new DoubleSafeSingleton();
                }
            }
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
