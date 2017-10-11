package pers.wxp.type.synchroniz;

/**
 * @author wxp
 * @date 2017年10月11日 上午9:34:11
 * @Description: TODO(修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；)
 */
class SynchronizedMethod implements Runnable {
	private static int count;

	public SynchronizedMethod() {
		count = 0;
	}

	public synchronized static void method() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + ":" + (count++));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void run() {
		method();
	}

	public static void main(String[] args) {
		SynchronizedMethod syncThread1 = new SynchronizedMethod();
		SynchronizedMethod syncThread2 = new SynchronizedMethod();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread2, "SyncThread2");
		thread1.start();
		thread2.start();
	}
}
