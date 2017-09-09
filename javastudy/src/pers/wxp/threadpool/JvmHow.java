package pers.wxp.threadpool;

public class JvmHow {

	/**
	 * @param args
	 *            最大内存（maxMemory）是通过启动JAVA虚拟机时使用参数-Xmx100m指定的，而输出也确实是100m。
	 *            这表示JVM的堆内存最大可以使用104071168字节。
	 * 
	 *            已分配内存（totalMemory）jvm使用的内存都是从本地系统获取的，但是通常jvm刚启动的时候，
	 *            并不会向系统申请全部的内存。而是根据所加载的Class和相关资源的容量来决定的。在本例中，由于只在一个main()
	 *            主方法中执行了上面的几行简单的代码。所以JVM只申请了5177344字节的内存。
	 * 
	 *            已分配内存中的剩余空间(freeMemory)
	 *            这是相对以分配内存（totalMemeory）计算的，相当于totalMemory - 已使用内存。当freeMemory
	 *            快要接近0时，以分配的内存即将耗尽，JVM会决定再次向系统申请更多的内存。
	 * 
	 *            最大可用内存 （usable）这是JVM真正还可以再继续使用的内存（不考虑之后垃圾回收再次得到的内存）。由【最大内存 -
	 *            已分配内存 + 已分配内存中的剩余空间】计算得到。
	 */
	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();

		long max = run.maxMemory();

		long total = run.totalMemory();

		long free = run.freeMemory();

		long usable = max - total + free;
		String string = "";
		for (int i = 0; i < 30000; i++) {
			string += i;
		}

		System.out.println("最大内存 = " + max);
		System.out.println("已分配内存 = " + total);
		System.out.println("已分配内存中的剩余空间 = " + free);
		System.out.println("最大可用内存 = " + usable);
		run.gc();
		
		long max1 = run.maxMemory();

		long total1 = run.totalMemory();

		long free1 = run.freeMemory();

		long usable1 = max - total + free;
		System.out.println("最大内存 = " + max1);
		System.out.println("已分配内存 = " + total1);
		System.out.println("已分配内存中的剩余空间 = " + free1);
		System.out.println("最大可用内存 = " + usable1);
	}
}
