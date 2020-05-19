package pers.wxp.type.statictest;

import lombok.SneakyThrows;

/**
 * @author wuxiaopeng
 * @description: 双重校验锁实现对象单例（线程安全）
 * @date 2020/3/17 15:43
 */
public class Singleton2 {
    /**需要注意 uniqueInstance 采用 volatile 关键字修饰也是很有必要。*/
    private volatile static Singleton2 uniqueInstance;

    private Singleton2() {
    }

    /**
     * uniqueInstance 采用 volatile 关键字修饰也是很有必要的， uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
     * 1、为 uniqueInstance 分配内存空间
     * 2、初始化 uniqueInstance
     * 3、将 uniqueInstance 指向分配的内存地址
     * @return
     */
    public static Singleton2 getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton2.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton2();
                }
            }
        }
        System.out.println(Thread.currentThread().getName());
        return uniqueInstance;
    }

    public static void main(String[] args) {
        System.out.println("开始");
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getUniqueInstance();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
