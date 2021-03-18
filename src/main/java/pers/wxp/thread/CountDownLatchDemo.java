package pers.wxp.thread;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CountDownLatchDemo {
    private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY:MM:dd hh:mm:ss");
    // 创建10个线程放入线程池内
    private static ExecutorService threadPool = Executors.newScheduledThreadPool(10);
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doHandler();
            }).start();
        }
    }

    public static final int THREAD_NUM = 100;
    public static void doHandler() {
        try {
            List<Integer> list = new ArrayList();
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            for (int num = 0; num < THREAD_NUM; num++) {
                List<Integer> newList = new ArrayList<>();
                //线程阻塞
                CountDownLatch latch = new CountDownLatch(list.size());
                //添加new Thread
//                list.forEach(n->{
//                    threadPool.execute(new Thread(()->{
//                        try {
//                            TimeUnit.SECONDS.sleep(random.nextInt(5));
//                            System.out.println(Thread.currentThread().getName() + ":" + sdf.format(new Date()));
//                            newList.add(n);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }finally {
//                            latch.countDown();
//                        }
//                    }));
//                });
                list.forEach(n->{
                    threadPool.execute(()->{
                        try {
                            TimeUnit.SECONDS.sleep(random.nextInt(10));
                            System.out.println(Thread.currentThread().getName() + ":" + sdf.format(new Date()) + "： 数字 ：" + n);
                            newList.add(n);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            latch.countDown();
                        }
                    });
                });
                System.out.println("线程开始");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + sdf.format(new Date()));
                System.out.println(newList.size());
                newList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(n->{
                    System.out.println("线程数数字：{}" + n);
                });
                if (newList.size() != 10) {
                    System.out.println("线程等待异常");
                }
                System.out.println("线程结束");
                //关掉线程池
                //threadPool.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    @Test
    public void ThreadTest() throws InterruptedException {
        while (true) {
            SecureRandom random = new SecureRandom();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            List<Integer> newList = new ArrayList<>();
            //线程阻塞
            CountDownLatch latch = new CountDownLatch(list.size());
            int j = 0;
            list.forEach(n -> {
                new Thread(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(random.nextInt(5));
                        System.out.println(Thread.currentThread().getName() + ":" + sdf.format(new Date()));
                        newList.add(n);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }, "线程" + n).start();
            });
            latch.await();
            System.out.println(Thread.currentThread().getName() + ":" + sdf.format(new Date()));
            System.out.println(newList.size());
        }
    }
}
