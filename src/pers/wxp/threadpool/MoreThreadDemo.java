package pers.wxp.threadpool;

import org.junit.Test;

public class MoreThreadDemo {
	private volatile Thread t1;//
	private volatile Thread t2;
	private volatile Thread t3;

	public void ChoiceThreadT1(String s) {
		if ("off".equals(s)) {
			System.out.println("关闭线程");
			t1.stop();
		} else if ("on".equals(s)) {
			t1 = new Thread(new Runnable() {

				// run的方法体代表要执行的任务
				@Override
				public void run() {
					int i = 0;
					System.out.println("打开线程");
					while (true) {
						System.out.println("线程1：" + ++i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			});
			// 启动线程
			t1.start();
		}
	}
	
	public void ChoiceThreadT2(String s) {
		if ("off".equals(s)) {
			System.out.println("关闭线程");
			t2.stop();
		} else if ("on".equals(s)) {
			t2 = new Thread(new Runnable() {

				// run的方法体代表要执行的任务
				@Override
				public void run() {
					int i = 0;
					System.out.println("打开线程");
					while (true) {
						System.out.println("线程2：" + ++i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			});
			// 启动线程
			t2.start();
		}
	}
	
	public void ChoiceThreadT3(String s) {
		if ("off".equals(s)) {
			System.out.println("关闭线程");
			t3.stop();
		} else if ("on".equals(s)) {
			t3 = new Thread(new Runnable() {

				// run的方法体代表要执行的任务
				@Override
				public void run() {
					int i = 0;
					System.out.println("打开线程");
					while (true) {
						System.out.println("线程3：" + ++i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			});
			// 启动线程
			t3.start();
		}
	}

	@Test // 采用这种方式没法执行线程
	public void ThreadExe() {
		ChoiceThreadT1("on");
		System.out.println("123");

	}

	public static void main(String[] args) throws InterruptedException {
		MoreThreadDemo mDemo = new MoreThreadDemo();
		mDemo.ChoiceThreadT1("on");//打开线程
		Thread.sleep(2000);
		mDemo.ChoiceThreadT1("off");//关闭线程
		mDemo.ChoiceThreadT2("on");//打开线程
		mDemo.ChoiceThreadT3("on");//打开线程
	}
}
