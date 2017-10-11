package pers.wxp.type.synchroniz;

/**
 * @author wxp
 * @date 2017年10月11日 上午9:46:57
 * @Description: TODO(synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁。)
 */
public class SynchronizedClass {

}

class SyncThreadClass implements Runnable {
	private static int count;

	public SyncThreadClass() {
		count = 0;
	}

	public static void method() {
		synchronized (SyncThread.class) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void run() {
		method();
	}

	public static void main(String[] args) {
		SyncThreadClass syncThreadClass1 = new SyncThreadClass();
		SyncThreadClass syncThreadClass2 = new SyncThreadClass();
		Thread thread1 = new Thread(syncThreadClass1, "syncThreadClass1");
		Thread thread2 = new Thread(syncThreadClass2, "syncThreadClass2");
		thread1.start();
		thread2.start();
	}

}