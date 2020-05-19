package pers.wxp.thread.function;

/**
 * 手动设置休眠时间
 */
class SleepDemo extends Thread {
	private int time;

	public SleepDemo(String name, int time) {
		super(name);
		this.time = time;
	}

	@Override
	public void run() {
		try {
			// 休眠时间
			Thread.sleep(this.time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "线程" + this.time + "毫秒");
	}

	public static void main(String args[]) {
		SleepDemo mt1 = new SleepDemo("A", 1000);
		SleepDemo mt2 = new SleepDemo("B", 2000);
		SleepDemo mt3 = new SleepDemo("C", 3000);
		mt1.start();
		mt2.start();
		mt3.start();
	}
}
