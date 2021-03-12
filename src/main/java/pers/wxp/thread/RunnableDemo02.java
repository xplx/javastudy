package pers.wxp.thread;

class RunnableDemo02 implements Runnable {
	private int ticket = 5;
	private String name;// 属性

	public RunnableDemo02(String name) {// 构造方法
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			if (this.ticket > 0) {
				System.out.println(name + "票数ticket = " + ticket--);
			}
		}
	}

	public static void main(String args[]) {
		RunnableDemo02 mt = new RunnableDemo02("线程1"); // 实例化
		RunnableDemo02 mt1 = new RunnableDemo02("线程2"); // 实例化
		RunnableDemo02 mt2 = new RunnableDemo02("线程3"); // 实例化
//		new Thread(mt).run(); //
//		new Thread(mt1).run(); // 数据未能实现共享，各种线程拥有各自数据
//		new Thread(mt2).run(); //
		
		new Thread(mt).run(); //启动三个线程实现数据共享
		new Thread(mt).run(); //
		new Thread(mt).run(); //
	}
}