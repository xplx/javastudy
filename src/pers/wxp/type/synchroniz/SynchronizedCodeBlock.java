package pers.wxp.type.synchroniz;

/**
 * @author wxp
 * @date 2017年10月11日 上午9:30:16
 * @Description: TODO(synchronized修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，
 *               作用的对象是调用这个代码块的对象；)
 */
public class SynchronizedCodeBlock {

}

class SynchronizedDemo implements Runnable {
	private static int count;

	public SynchronizedDemo() {
		count = 0;
	}

	/*
	 * 当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码块时，
	 * 在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后才能执行该代码块。Thread1和thread2是互斥的，
	 * 因为在执行synchronized代码块时会锁定当前的对象，只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象。
	 */
	public void run() {
		synchronized (this) {
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

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		// syncThread同一对象的同步代码块,因为在执行synchronized代码块时会锁定当前的对象，
		// 只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象。
		SynchronizedDemo syncThread = new SynchronizedDemo();
		// Thread thread1 = new Thread(syncThread, "SyncThread1");
		// Thread thread2 = new Thread(syncThread, "SyncThread2");
		// thread1.start();
		// thread2.start();

		// synchronized锁定的是对象,这时会有两把锁分别锁定syncThread1对象和syncThread2对象，
		// 而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
		SynchronizedDemo syncThread1 = new SynchronizedDemo();
		SynchronizedDemo syncThread2 = new SynchronizedDemo();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread2, "SyncThread2");
		thread1.start();
		thread2.start();

	}
}

/**
 * @author wxp
 * @date 2017年10月11日 上午8:48:59
 * @Description: TODO(当一个线程访问对象的一个synchronized(this)同步代码块时，
 *               另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。)
 */
class Counter implements Runnable {
	private int count;

	public Counter() {
		count = 0;
	}

	public void countAdd() {
		synchronized (this) {
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

	// 非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
	public void printCount() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " count:" + count);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		if (threadName.equals("A")) {
			countAdd();
		} else if (threadName.equals("B")) {
			printCount();
		}
	}

	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread thread1 = new Thread(counter, "A");
		Thread thread2 = new Thread(counter, "B");
		thread1.start();
		thread2.start();
	}
}

/**
 * 指定要给某个对象加锁
 */
class Account {
	String name;
	float amount;

	public Account(String name, float amount) {
		this.name = name;
		this.amount = amount;
	}

	// 存钱
	public void deposit(float amt) {
		amount += amt;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 取钱
	public void withdraw(float amt) {
		amount -= amt;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public float getBalance() {
		return amount;
	}
}

/**
 * 账户操作类
 */
class AccountOperator implements Runnable {
	private Account account;

	public AccountOperator(Account account) {
		this.account = account;
	}

	/*
	 * 用synchronized 给account对象加了锁。这时，当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞，
	 * 直到该线程访问account对象结束。也就是说谁拿到那个锁谁就可以运行它所控制的那段代码。
	 */
	// public void run() {
	// synchronized (account) {
	// account.deposit(500);
	// account.withdraw(500);
	// System.out.println(Thread.currentThread().getName() + ":" +
	// account.getBalance());
	// }
	// }

	/*
	 * (non-Javadoc) 同步方法
	 */
	public synchronized void run() {
		account.deposit(500);
		account.withdraw(500);
		System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
	}

	public static void main(String[] args) {
		Account account = new Account("zhang san", 10000.0f);
		AccountOperator accountOperator = new AccountOperator(account);

		final int THREAD_NUM = 5;
		Thread threads[] = new Thread[THREAD_NUM];
		for (int i = 0; i < THREAD_NUM; i++) {
			threads[i] = new Thread(accountOperator, "Thread" + i);
			threads[i].start();
		}
	}
}
