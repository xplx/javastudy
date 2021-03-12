package pers.wxp.threadpool;

import pers.wxp.util.LogPrintUtil;

import java.util.concurrent.CountDownLatch;

/**
 * @author lenovo
 * @date 2020-11-25
 */
public class CountDownLatchDemoOne {
    static class TaskThread extends Thread {

        CountDownLatch latch;
        public TaskThread(CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public void run() {
            try {
                sleep(1000);
                latch.await();
                System.out.println(getName() + " start " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LogPrintUtil.print("开始");
        int threadNum = 10;
        CountDownLatch latch = new CountDownLatch(1);
        for(int i = 0; i < threadNum; i++) {
            TaskThread task = new TaskThread(latch);
            task.start();
        }
        Thread.sleep(1000);
        latch.countDown();
        latch.await();
        LogPrintUtil.print("结束");
    }
}
