package pers.wxp.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * new Thread的弊端如下：
 * a. 每次new Thread新建对象性能差。
 * b. 线程缺乏统一管理，可能无限制新建线程，相互之间竞争，及可能占用过多系统资源导致死机或oom。
 * c. 缺乏更多功能，如定时执行、定期执行、线程中断。
 *
 * 相比new Thread，Java提供的四种线程池的好处在于：
 * a. 重用存在的线程，减少对象创建、消亡的开销，性能佳。
 * b. 可有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞。
 * c. 提供定时执行、定期执行、单线程、并发数控制等功能。
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();// 创建Runtime对象
        run.gc();// 运行垃圾回收器，这样可以减少误差
        long freeMemory = run.freeMemory();// 获得当前虚拟机的空闲内存
        long currentTime = System.currentTimeMillis();// 获得当前虚拟机的时间
        for (int i = 0; i < 1000; i++) {// 独立运行1000个线程
            new Thread(new TempThread()).start();
        }
        long memory = freeMemory - run.freeMemory();
        long time = System.currentTimeMillis() - currentTime;
        System.out.println("独立运行1000个线程所占用的内存：" + memory + "字节");// 查看内存的变化
        System.out.println("独立创建1000个线程所消耗的时间：" + time + "毫秒");// 查看时间的变化
        run.gc();// 运行垃圾回收器
        
        freeMemory = run.freeMemory();// 获得当前虚拟机的空闲内存
        currentTime = System.currentTimeMillis();// 获得当前虚拟机的时间
        ExecutorService executorService = Executors.newFixedThreadPool(2);// 创建线程池
        for (int i = 0; i < 1000; i++) {// 使用线程池运行1000个线程
            executorService.submit(new TempThread());
        }
        memory = freeMemory - run.freeMemory();
        time = System.currentTimeMillis() - currentTime;
        System.out.println("使用连接池运行1000个线程所占用的内存：" + memory + "字节");// 查看内存的变化
        System.out.println("使用连接池创建1000个线程所消耗的时间：" + time + "毫秒");// 查看时间的变化
    }
}
