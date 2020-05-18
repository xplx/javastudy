package pers.wxp.thread.synchroniz;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/20 11:26
 */
public class SynchronizedDemo1 {
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo1 s = new SynchronizedDemo1();
        s.method();
    }
}
