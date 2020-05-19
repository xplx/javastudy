package pers.wxp.thread.function;

import java.util.Date;

class ThreadSleepDemo implements Runnable {
	@Override
	public void run() {
		while (true) {
			Date d1 = new Date();
			for (int i = 0; i < 5; i++) {
				try {
					// 休眠要通过thread调用。
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println(Thread.currentThread().getName() + "运行 = " + i);
			}
			Date d2 = new Date();
			System.out.println(d1);
			System.out.println(d2);
			Long tLong = (d2.getTime() - d1.getTime()) / 1000;
			System.out.println(tLong);
		}

	}

	public static void main(String args[]) {
		ThreadSleepDemo mt = new ThreadSleepDemo();
		Thread t = new Thread(mt, "线程");
		t.start();
	}
}
