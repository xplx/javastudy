package pers.wxp.thread;

class ThreadDemo extends Thread {//继承Thread，线程得操作类
	private Thread t;            
	private String threadName;  //线程得名称

	ThreadDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() { //线程得主体
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// 让线程睡醒一会
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public static void main(String args[]) {
		ThreadDemo T1 = new ThreadDemo("Thread-1");//实例化线程1
		ThreadDemo T2 = new ThreadDemo("Thread-2");//实例化线程2
//		T1.start();		
		T2.start();//start()采用并发的方式执行
//		T1.run();//run()采用按顺序的方式
//		T2.run();
	}
}
