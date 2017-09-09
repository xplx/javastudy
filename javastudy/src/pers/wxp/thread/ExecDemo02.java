package pers.wxp.thread;

class ExecMethed implements Runnable {
	private String name;
	private String ip;
	private String port;

	ExecMethed(String ip, String port, String name) {
		this.ip = ip;
		this.port = port;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ip是：" + this.ip + "port是：" + this.port + "名称" + this.name);
		}
	}

}

class ExecMethedOne implements Runnable {
	private String name;
	private int time;
	private boolean flag = true;
	// 该线程代表执行任务的线程
	private volatile Thread t1;

	public ExecMethedOne(String name, int time) {
		this.name = name;// 休眠时间
		this.time = time;
	}

	public void run() {
		while (this.flag) {
			try {
				Thread.sleep(this.time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.name + "线程" + this.time + "号秒");
		}
	}

	public void stop() {
		this.flag = false;
	}

	public void awaken() {
		this.flag = true;
	}

	public void ChoiceThread(String s) {
		if ("off".equals(s)) {
			t1.stop();
		} else if ("on".equals(s)) {
			t1 = new Thread(new Runnable() {

				// run的方法体代表要执行的任务
				@Override
				public void run() {
					int i = 0;
					while (i < 10000000) {
						System.out.println(++i);
					}

				}
			});
			// 启动线程
			t1.start();
		}
	}

	public void StartThread() {
		ExecMethedOne mt1 = new ExecMethedOne("A", 100);
		ExecMethedOne mt2 = new ExecMethedOne("B", 200);
		ExecMethedOne mt3 = new ExecMethedOne("C", 300);
		// new Thread(mt1).start();//直接启动线程，不创建线程对象
		// new Thread(mt2).start();
		// new Thread(mt3).start();
		Thread thread = new Thread(mt1, "线程A");// 创建线程对象
		thread.start();// 启动线程
		System.out.println("线程开始之前 " + thread.isAlive());// 判断线程是否在运行
	}

}

public class ExecDemo02 {
	public static void main(String args[]) throws InterruptedException {
		ExecMethedOne mt1 = new ExecMethedOne("A", 100);

		ExecMethed methed = new ExecMethed("192.168.0.160", "4001", "变压器");
		mt1.StartThread();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		mt1.stop();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// thread.start();

	}
}
