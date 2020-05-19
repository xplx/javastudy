package pers.wxp.thread.function;

class ThreadPriorityDemo implements Runnable { 
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + "运行线程 = " + i);
		}
	}

	public static void main(String args[]) {
		Thread t1 = new Thread(new ThreadPriorityDemo(), "线程A"); 
		Thread t2 = new Thread(new ThreadPriorityDemo(), "线程B"); 
		Thread t3 = new Thread(new ThreadPriorityDemo(), "线程C");
		//设置最低优先级
		t1.setPriority(Thread.MIN_PRIORITY);
		//设置最高优先级
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY); 
		t1.start(); 
		t2.start(); 
		t3.start(); 
	}
}
