package pers.wxp.thread.security;

/**
 * @author wuxiaopeng
 * @description: 同步线程
 * @date 2020/3/17 10:51
 */
public class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        /**只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象。
         * synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联
         * */
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
