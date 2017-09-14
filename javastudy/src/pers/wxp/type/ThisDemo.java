package pers.wxp.type;

import org.junit.Test;

/**
 * @author wxp
 * @date 2017-6-12
 */
public class ThisDemo {

	@Test
	public void printf() {
		System.out.println("��ǰ����" + this);
	}

	/**
	 * @param args
	 * this ���õ������Ķ���
	 */
	public static void main(String[] args) {
		ThisDemo thisDemo = new ThisDemo();
		ThisDemo thisDemo1 = new ThisDemo();
		System.out.println(thisDemo);
		thisDemo.printf();
		System.out.println(thisDemo1);//��ӡ�������Ķ���
		thisDemo1.printf();
	}
}
