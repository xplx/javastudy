package pers.wxp.thread.pool;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/18 10:46
 */
public class MyRunnable implements Runnable {
    private CountDownLatch countDownLatch;

    public MyRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        synchronized (countDownLatch) {
            countDownLatch.countDown();
            System.out.println("thread counts = " + (countDownLatch.getCount()));
        }
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
