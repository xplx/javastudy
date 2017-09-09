package pers.wxp.thread;

class ThreadYieldDemo implements Runnable { // ʵ��Runnable�ӿ�
	public void run() { // ��дrun()����
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			System.out.println(Thread.currentThread().getName() + "运行= " + i); // ȡ�õ�ǰ�̵߳�����
			if (i == 2) {
				System.out.print("礼让");
				Thread.currentThread();
				Thread.yield();
			}
		}
	}

	public static void main(String args[]) {
		ThreadYieldDemo my = new ThreadYieldDemo(); // ʵ��MyThread����
		Thread t1 = new Thread(my, "A");
		Thread t2 = new Thread(my, "B");
		t1.start();
		t2.start();
	}
}
