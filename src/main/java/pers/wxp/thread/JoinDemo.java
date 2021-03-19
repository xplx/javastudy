package pers.wxp.thread;

/**
 * @author wxp
 * @date 2021-3-19
 * join():t.join()方法只会使主线程进入等待池并等待t线程执行完毕后才会被唤醒。
 * 并不影响同一时刻处在运行状态的其他线程。
 * 这是因为线程在die的时候会自动调用自身的notifyAll方法，来释放所有的资源和锁。
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");
        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");
        ThreadTest t3 = new ThreadTest("C");
        System.out.println("t1start");
        t1.start();
        t1.join();
        System.out.println("t1end");
        System.out.println("t2start");
        t2.start();
        System.out.println("t2end");
        System.out.println("t3start");
        t3.start();
        System.out.println("t3end");
        System.out.println(Thread.currentThread().getName() + " end");
    }

    static class ThreadTest extends Thread {
        private String name;
        public ThreadTest(String name){
            this.name=name;
        }
        @Override
        public void run(){
            for(int i=1;i<=5;i++){
                System.out.println(name+"-"+i);
            }
        }
    }
}
