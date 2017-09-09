package pers.wxp.exception;

import org.junit.Test;

/**
 * @author 作者 E-mail:
 * @date 创建时间：2017年6月12日 下午5:39:46
 * @Description: TODO(这里用一句话描述这个类的作用)
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
