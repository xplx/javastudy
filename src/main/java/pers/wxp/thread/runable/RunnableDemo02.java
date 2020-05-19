package pers.wxp.thread.runable;

/**
 * run()方法是在本线程里的，只是线程里的一个函数，而不是多线程的。
 * 如果直接调用run()，其实就相当于是调用了一个普通函数而已，
 * 直接待用run()方法必须等待run()方法执行完毕才能执行下面的代码，
 * 所以执行路径还是只有一条，根本就没有线程的特征，
 * 所以在多线程执行时要使用start()方法而不是run()方法。
 */
class RunnableDemo02 implements Runnable {
    //这里需要使用static使用，线程才能共享。
    private static volatile int ticket = 5;
    //这里不使用static时，线程不能共享
    //private int ticket = 5;
    private String name;

    public int getTicket() {
        return ticket;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + "票数ticket = " + ticket--);
            }
        }
    }

    public static void main(String args[]) {
        RunnableDemo02 mt = new RunnableDemo02();
        RunnableDemo02 mt1 = new RunnableDemo02();
        RunnableDemo02 mt2 = new RunnableDemo02();
        // 数据未能实现共享，各种线程拥有各自数据,使用run是顺序执行，
        // 如果直接调用run()，其实就相当于是调用了一个普通函数而已，
//        new Thread(mt).run();
//        new Thread(mt1).run();
//        new Thread(mt2).run();

        Thread thread = new Thread(mt);
        Thread thread1 = new Thread(mt);
        Thread thread2 = new Thread(mt);
        thread.start();
        thread1.start();
        thread2.start();
        //启动三个线程实现数据共享
//        new Thread(mt).run();
//        new Thread(mt).run();
//        new Thread(mt).run();
    }
}