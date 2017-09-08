package pers.wxp.timer;

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
 * @author Administrator 所以如果存在多个任务，且任务时间过长，超过了两个任务的间隔时间，会发生一些缺陷：下面看例子：
 *
 */
public class TimerDemo {

	private static long start;

	/**
	 * 定义了两个任务，预计是第一个任务1s后执行，第二个任务3s后执行，但是看运行结果： task1 invoked ! 1000 task2
	 * invoked ! 4001 task2实际上是4后才执行，正因为Timer内部是一个线程，而任务1所需的时间超过了两个任务间的间隔导致
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
	 * 由于任务1的一次异常抛出，任务2也停止运行了
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
		timer.schedule(task1, 100);// 单次执行任务。
		timer.scheduleAtFixedRate(task2, new Date(), 1000);// z周期性执行任务。

	}

	public static void main(String[] args) throws Exception {
		timerDemo1();// 不是并发运行
		// timerDemo2();// 出异常时，回报错其他定时会停止
	}
}

/**
 * @author Administrator
 *         ScheduledThreadPool解决这个问题：符合我们的预期结果。因为ScheduledThreadPool内部是个线程池，
 *         所以可以支持多个任务并发执行。
 */
class ScheduledThreadPoolExecutorTest {
	private static long start;

	public static void ScheduledThreadPoolExecutorTest1() {
		/**
		 * 使用工厂方法初始化一个ScheduledThreadPool
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
		// 两次开始执行最小间隔时间,按指定频率周期执行某个任务
		// pool.scheduleAtFixedRate(task2, 0, 3000,
		// TimeUnit.MILLISECONDS);//如果线程延迟大于指定周期，则会以线程的延迟结束后运行。
		// 间隔指的是连续两次任务开始执行的间隔,按指定频率间隔执行某个任务。
		pool.scheduleWithFixedDelay(task2, 0, 1000, TimeUnit.MILLISECONDS);
	}

	/**
	 * 每天晚上8点执行一次 每天定时安排任务进行执行
	 */
	public static void executeEightAtNightPerDay() {
		final TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("每天定时执行一次任务");
			}
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		long oneDay = 24 * 60 * 60 * 1000;
		long initDelay = getTimeMillis("16:59:00") - System.currentTimeMillis();
		initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

		executor.scheduleAtFixedRate(task1, initDelay, oneDay, TimeUnit.MILLISECONDS);
	}

	/**
	 * 获取指定时间对应的毫秒数
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
		// ScheduledThreadPoolExecutorTest1();// 并发运行任务		
		//ScheduledThreadPoolExecutorTest2();// 其中任务报错，其他任务不会停止运行
		executeEightAtNightPerDay();//每天定时执行一次任务。
	}
}