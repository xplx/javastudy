package pers.wxp.thread.function;

class ThreadInterruptDemo implements Runnable {
	@Override
	public void run() {
		System.out.println("开始运行线程");
		try {
			Thread.sleep(10000);
			System.out.println("完成线程休眠");
		} catch (InterruptedException e) {
			System.out.println("线程异常");
			return;
		}
		System.out.println("线程结束");
	} 

	public static void main(String args[]) {
		ThreadInterruptDemo mt = new ThreadInterruptDemo();
		Thread t = new Thread(mt, "线程");
		t.start();
		try {
			Thread.sleep(2000);
			System.out.println("线程结束");
		} catch (InterruptedException e) {
			System.out.println("异常ֹ");
		}
		t.interrupt();//中断线程
	}
}
