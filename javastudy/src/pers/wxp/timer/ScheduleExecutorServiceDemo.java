package pers.wxp.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ScheduleExecutorServiceDemo {
	/**
	 * 以固定周期频率执行任务
	 */
	@Test
	public static void executeFixedRate() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(print(), 0, 100, TimeUnit.MILLISECONDS);
	}

	public static Runnable print() {
		System.out.println("test");
		return null;
	}
}
