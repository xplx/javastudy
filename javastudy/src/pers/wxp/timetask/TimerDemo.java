package pers.wxp.timetask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator ���������ڶ������������ʱ����������������ļ��ʱ�䣬�ᷢ��һЩȱ�ݣ����濴���ӣ�
 *
 */
public class TimerDemo {

	private static long start;

	/**
	 * ��������������Ԥ���ǵ�һ������1s��ִ�У��ڶ�������3s��ִ�У����ǿ����н�� task1 invoked ! 1000 task2
	 * invoked ! 4001 task2ʵ������4���ִ�У�����ΪTimer�ڲ���һ���̣߳�������1�����ʱ�䳬�������������ļ������
	 */
	public static void timerDemo1() {
		TimerTask task1 = new TimerTask() {
			@Override
			public void run() {

				System.out.println("task1 invoked ! " + (System.currentTimeMillis() - start));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};
		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				System.out.println("task2 invoked ! " + (System.currentTimeMillis() - start));
			}
		};
		Timer timer = new Timer();
		start = System.currentTimeMillis();
		// timer.schedule(task1, 1000);
		timer.scheduleAtFixedRate(task1, 0, 1000);
		timer.schedule(task2, 3000);
	}

	/**
	 * ��������1��һ���쳣�׳�������2Ҳֹͣ������
	 */
	public static void timerDemo2() {

		final TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				throw new RuntimeException();
			}
		};

		final TimerTask task2 = new TimerTask() {

			@Override
			public void run() {
				System.out.println("task2 invoked!");
			}
		};

		Timer timer = new Timer();
		timer.schedule(task1, 100);// ����ִ������
		timer.scheduleAtFixedRate(task2, new Date(), 1000);// z������ִ������

	}

	public static void main(String[] args) throws Exception {
		timerDemo1();// ���ǲ�������
		// timerDemo2();// ���쳣ʱ���ر�������ʱ��ֹͣ
	}
}

/**
 * @author Administrator
 *         ScheduledThreadPool���������⣺������ǵ�Ԥ�ڽ����ΪScheduledThreadPool�ڲ��Ǹ��̳߳أ�
 *         ���Կ���֧�ֶ�����񲢷�ִ�С�
 */
class ScheduledThreadPoolExecutorTest {
	private static long start;

	public static void ScheduledThreadPoolExecutorTest1() {
		/**
		 * ʹ�ù���������ʼ��һ��ScheduledThreadPool
		 */
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);

		TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				try {

					System.out.println("task1 invoked ! " + (System.currentTimeMillis() - start));
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};

		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {

				System.out.println("task2 invoked ! " + (System.currentTimeMillis() - start));
			}
		};
		start = System.currentTimeMillis();
		newScheduledThreadPool.schedule(task1, 1000, TimeUnit.MICROSECONDS);
		newScheduledThreadPool.schedule(task2, 3000, TimeUnit.MILLISECONDS);
	}

	public static void ScheduledThreadPoolExecutorTest2() {
		final TimerTask task1 = new TimerTask() {

			@Override
			public void run() {
				throw new RuntimeException();
			}
		};

		final TimerTask task2 = new TimerTask() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("task2 invoked!");
				System.out.println((System.currentTimeMillis() - start) / 1000);
			}
		};

		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		// pool.schedule(task1, 100, TimeUnit.MILLISECONDS);
		// pool.schde
		// ���ο�ʼִ����С���ʱ��,��ָ��Ƶ������ִ��ĳ������
		// pool.scheduleAtFixedRate(task2, 0, 3000,
		// TimeUnit.MILLISECONDS);//����߳��ӳٴ���ָ�����ڣ�������̵߳��ӳٽ�������С�
		// ���ָ����������������ʼִ�еļ��,��ָ��Ƶ�ʼ��ִ��ĳ������
		pool.scheduleWithFixedDelay(task2, 0, 1000, TimeUnit.MILLISECONDS);
	}

	/**
	 * ÿ������8��ִ��һ�� ÿ�춨ʱ�����������ִ��
	 */
	public static void executeEightAtNightPerDay() {
		final TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("ÿ�춨ʱִ��һ������");
			}
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		long oneDay = 24 * 60 * 60 * 1000;
		long initDelay = getTimeMillis("16:59:00") - System.currentTimeMillis();
		initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

		executor.scheduleAtFixedRate(task1, initDelay, oneDay, TimeUnit.MILLISECONDS);
	}

	/**
	 * ��ȡָ��ʱ���Ӧ�ĺ�����
	 * 
	 * @param time
	 *            "HH:mm:ss"
	 * @return
	 */
	private static long getTimeMillis(String time) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
			Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
			return curDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		// ScheduledThreadPoolExecutorTest1();// ������������		
		//ScheduledThreadPoolExecutorTest2();// �������񱨴?�������񲻻�ֹͣ����
		executeEightAtNightPerDay();//ÿ�춨ʱִ��һ������
	}
}