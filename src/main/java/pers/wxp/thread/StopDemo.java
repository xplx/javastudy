package pers.wxp.thread;

class MyStopDemo implements Runnable {
	private boolean flag = true; 

	public void run() {
		int i = 0;
		while (this.flag) {
			System.out.println(Thread.currentThread().getName() + "运行次数 = " + (i++));
		}
	}

	public void stop() {
		this.flag = false;
	}
};

public class StopDemo {
	public static void main(String args[]) {
		MyStopDemo my = new MyStopDemo();
		Thread t = new Thread(my,"线程1");
		t.start();
		try {
			Thread.sleep(30);
		} catch (Exception e) {

		}
		my.stop();//停止线程
	}
};