package pers.wxp.thread;

/**
 * 实现runnable，其中runnable只有一个借口run（）主体方法
 * 
 */
class RunnableDemo01 implements Runnable {
	private String ip;// 属性
	private String port;// 属性

	public RunnableDemo01(String ip, String port) {// 方法
		this.ip = ip;
		this.port = port;

	}

	public void run() { // 覆写run主体方法，执行线程
		for (int i = 0; i < 100; i++) {
			System.out.println("ip是：" + ip + "port是：" + port + "运行次数" + i);

		}
	}

	public static void main(String args[]) {
		RunnableDemo01 mt1 = new RunnableDemo01("192.168.0.160", "4001"); //
		RunnableDemo01 mt2 = new RunnableDemo01("192.168.0.161", "4001");
		// mt1.run();//直接运行run（）方法
		// mt2.run();//顺序执行
		Thread t1 = new Thread(mt1); // 接收runnable接口子类对象，实例化thread
		Thread t2 = new Thread(mt2);// 采用此方法抢占CPU资源，谁拥有就CPU就运行谁
		t1.start(); //
		t2.start(); //
	}
}