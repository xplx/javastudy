package pers.wxp.thread;

class ThreadNameDemo implements Runnable { // ʵ��Runnable�ӿ�
	public void run() { // ��дrun()����
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "运行次数= " + i); // ȡ�õ�ǰ�̵߳�����
		}
	}

	public static void main(String args[]) {
		ThreadNameDemo mt = new ThreadNameDemo(); // ʵ��Runnable�������
		new Thread(mt).start(); // ϵͳ�Զ������߳����
		new Thread(mt, "A线程").start(); // �ֹ������߳����
		new Thread(mt, "B线程").start(); // �ֹ������߳����
		new Thread(mt).start(); // ϵͳ�Զ������߳����
		new Thread(mt).start(); // ϵͳ�Զ������߳����
	}
};

