package pers.wxp.thread;

class ThreadPriorityDemo implements Runnable { 
	public void run() { 
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + "运行线程 = " + i); // ȡ�õ�ǰ�̵߳�����
		}
	}

	public static void main(String args[]) {
		Thread t1 = new Thread(new ThreadPriorityDemo(), "线程A"); 
		Thread t2 = new Thread(new ThreadPriorityDemo(), "线程B"); 
		Thread t3 = new Thread(new ThreadPriorityDemo(), "线程C"); 
		t1.setPriority(Thread.MIN_PRIORITY); //设置最低优先级
		t2.setPriority(Thread.MAX_PRIORITY); //设置最高优先级
		t3.setPriority(Thread.NORM_PRIORITY); 
		t1.start(); 
		t2.start(); 
		t3.start(); 
	}
}
