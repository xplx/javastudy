package pers.wxp.thread.function;

class StopDemo implements Runnable {
	private boolean flag = true; 

	@Override
	public void run() {
		int i = 0;
		while (this.flag) {
			System.out.println(Thread.currentThread().getName() + "运行次数 = " + (i++));
		}
	}

	public void stop() {
		this.flag = false;
	}

	public static void main(String args[]) {
		StopDemo my = new StopDemo();
		Thread t = new Thread(my,"线程1");
		t.start();
		try {
			Thread.sleep(30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//停止线程
		my.stop();
	}
}