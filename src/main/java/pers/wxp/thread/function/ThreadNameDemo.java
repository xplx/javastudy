package pers.wxp.thread.function;

class ThreadNameDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "运行次数= " + i);
        }
    }

    public static void main(String args[]) {
        ThreadNameDemo mt = new ThreadNameDemo();
        new Thread(mt).start();
        new Thread(mt, "A线程").start();
        new Thread(mt, "B线程").start();
        new Thread(mt).start();
        new Thread(mt).start();
    }
};

