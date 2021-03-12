package pers.wxp.threadpool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import pers.wxp.util.LogPrintUtil;

import java.util.concurrent.CountDownLatch;

/**
 * @author lenovo
 * @date 2020-11-25
 */
public class CountDownLatchDemo {
    static class TaskThread extends Thread {
        CountDownLatch latch;

        public TaskThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(getName() + " Task is Done");
                System.out.println("线程数：" + latch.getCount());
                latch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            LogPrintUtil.print("开始");
            int threadNum = 10;
            CountDownLatch latch = new CountDownLatch(threadNum);
            for(int i = 0; i < threadNum; i++) {
                TaskThread task = new TaskThread(latch);
                task.start();
            }
            System.out.println("Task Start!");
            latch.await();
            System.out.println("All Task is Done!");
            LogPrintUtil.print("结束");
        }
    }
}
