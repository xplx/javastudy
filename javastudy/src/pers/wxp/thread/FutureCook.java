package pers.wxp.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureCook {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long startTime = System.currentTimeMillis();
		// 第一步 网购厨具
		// Callable接口可以看作是Runnable接口的补充，call方法带有返回值，并且可以抛出异常
		Callable<Chuju> onlineShopping = new Callable<Chuju>() {
			@Override
			public Chuju call() throws Exception {
				System.out.println("第一步：下单");
				System.out.println("第一步：等待送货");
				Thread.sleep(5000); // 模拟送货时间
				System.out.println("第一步：快递送到");
				return new Chuju();
			}

		};
		// 把Callable实例当作参数，生成一个FutureTask的对象，然后把这个对象当作一个Runnable，作为参数另起线程。
		FutureTask<Chuju> task = new FutureTask<Chuju>(onlineShopping);
		new Thread(task).start();
		// 第二步 去超市购买食材
		Thread.sleep(2000); // 模拟购买食材时间
		Shicai shicai = new Shicai();
		System.out.println("第二步：食材到位");
		// 第三步 用厨具烹饪食材
		if (!task.isDone()) { // 联系快递员，询问是否到货
			System.out.println("第三步：厨具还没到，心情好就等着（心情不好就调用cancel方法取消订单）");
		}
		Chuju chuju = null;
		try {
			
			chuju = task.get(1,TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("第三步：厨具到位，开始展现厨艺");
		cook(chuju, shicai);

		System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
	}

	// 用厨具烹饪食材
	static void cook(Chuju chuju, Shicai shicai) {
	}

	// 厨具类
	static class Chuju {
	}

	// 食材类
	static class Shicai {
	}

}

class CommonCook {

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		// 第一步 网购厨具
		OnlineShopping thread = new OnlineShopping();
		thread.start();
		thread.join(); // 保证厨具送到
		// 第二步 去超市购买食材
		Thread.sleep(2000); // 模拟购买食材时间
		Shicai shicai = new Shicai();
		System.out.println("第二步：食材到位");
		// 第三步 用厨具烹饪食材
		System.out.println("第三步：开始展现厨艺");
		cook(thread.chuju, shicai);

		System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
	}

	// 网购厨具线程
	static class OnlineShopping extends Thread {

		private Chuju chuju;

		@Override
		public void run() {
			System.out.println("第一步：下单");
			System.out.println("第一步：等待送货");
			try {
				Thread.sleep(5000); // 模拟送货时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("第一步：快递送到");
			chuju = new Chuju();
		}

	}

	// 用厨具烹饪食材
	static void cook(Chuju chuju, Shicai shicai) {
	}

	// 厨具类
	static class Chuju {
	}

	// 食材类
	static class Shicai {
	}
}