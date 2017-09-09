package pers.wxp.thread;

class ExecDemo01 extends Thread {
	private int time;

	public ExecDemo01(String name, int time) {
		super(name);
		this.time = time;
	}

	public void run() {
		try {
			Thread.sleep(this.time); // 休眠时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "线程" + this.time + "毫秒");
	}

	public static void main(String args[]) {
		ExecDemo01 mt1 = new ExecDemo01("A", 1000);
		ExecDemo01 mt2 = new ExecDemo01("B", 2000);
		ExecDemo01 mt3 = new ExecDemo01("C", 3000);
		mt1.start();
		mt2.start();
		mt3.start();
	}
}
