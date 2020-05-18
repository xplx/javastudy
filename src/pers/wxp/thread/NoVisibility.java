package pers.wxp.thread;

/**
 * @author wuxiaopeng
 * @description: volatile能够保证可见性和防止指令重排
 * @date 2020/4/21 9:20
 */
public class NoVisibility {
    private static boolean ready;
    private static int a;

    public static void main(String[] args) throws InterruptedException {
        new ReadThread().start();
        Thread.sleep(100);
        a = 32;
        ready = true;
    }

    private static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(a);
        }
    }
}
