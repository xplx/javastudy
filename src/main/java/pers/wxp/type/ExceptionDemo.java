package pers.wxp.type;

import org.junit.Test;

/**
 * @author ���� E-mail:
 * @date ����ʱ�䣺2017��6��12�� ����5:39:46
 * @Description: TODO(������һ�仰��������������)
 * @version 1.0
 * @parameter
 */
public class ExceptionDemo {

	@Test
	public void exceptionDemo1() {

		try {
			int a = 10;
			int b = 0;
			int c = a / b;
			System.out.println(c);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
