package pers.wxp.thread;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/21 9:23
 */
public class VolatileTest {
    /**
     * 防止指令重排
     */
    public volatile int inc = 0;

    /**
     * 所以volatile不能保证原子性 。
     * 这时需要用锁来保证,在increase方法加上synchronized
     */
    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++){
                    test.increase();
                }
            }).start();
        }
        //保证前面的线程都执行完
        Thread.sleep(3000);
        System.out.println(test.inc);
    }
}
