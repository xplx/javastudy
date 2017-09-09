package pers.wxp.thistest;

import org.junit.Test;

/**
 * @author wxp
 * @date 2017-6-12
 */
public class ThisDemo {

	@Test
	public void printf() {
		System.out.println("当前对象：" + this);
	}

	/**
	 * @param args
	 * this 调用的是最近的对象
	 */
	public static void main(String[] args) {
		ThisDemo thisDemo = new ThisDemo();
		ThisDemo thisDemo1 = new ThisDemo();
		System.out.println(thisDemo);
		thisDemo.printf();
		System.out.println(thisDemo1);//打印的是最近的对象
		thisDemo1.printf();
	}
}
