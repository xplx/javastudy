package pers.wxp.thread;

/**
 * Thread.currentThread().getName()获取线程名称 
 * t.isAlive()判断线程是否执行，返回的是布尔值
 */
class ThreadAliveDemo implements Runnable {
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "运行= " + i);
		}
	}

	public static void main(String args[]) {
		ThreadAliveDemo mt = new ThreadAliveDemo();
		Thread t = new Thread(mt, "线程A");
		System.out.println("线程开始之前 " + t.isAlive());
		t.start();// 启动线程
		System.out.println("线程开始之后 " + t.isAlive());
		for (int i = 0; i < 3; i++) {
			System.out.println("main运行--> " + i);
		}
		System.out.println("代码执行之后 " + t.isAlive());

	}
}
