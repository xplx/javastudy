package pers.wxp.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wuxiaopeng
 */
public class ExecutorServiceDemo {
    /**初始化10个线程*/
    //public static ExecutorService executorService = Executors.newFixedThreadPool(10);
    /**单线程*/
    public static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("开始等待");
        boolean b = executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("等待完毕");
        if(b){
            System.out.println("分线程已经结束");
        }
        System.out.println(Thread.currentThread().getName());
    }
}
