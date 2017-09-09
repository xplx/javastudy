package pers.wxp.throwdemo;

import org.junit.Test;

/**
 * @author 作者 E-mail:
 * @date 创建时间：2017年6月13日 上午9:11:08
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @version 1.0
 * @parameter
 */
public class ThrowDemo extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Test
	public void ThrowDemo1() {
		try {
			throw new Exception("程序出错，请核查");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @date 2017年6月13日 上午9:22:32
	 * @Description: TODO(throws Exception 向上抛出异常)
	 * @Description: TODO(throws Exception 调用处抛出错误)
	 * @param a
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public float div(int a, int b) throws Exception {
		try {
			System.out.println("=======计算开始========");
			float c = a / b;
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {// finally在return之前执行
			System.out.println("=======计算结束========");
		}
	}

	@Test
	public void divDoIt() {
		try {
			System.out.println(div(10, 5));
			System.out.println(div(10, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @date 2017年6月13日 上午9:35:49
	 * @Description: TODO(RuntimeException可以选择是否处理异常，Exception必须处理异常)
	 */
	@Test
	public void ThrowDemo2() {
		String str1 = "123";
		int num = Integer.parseInt(str1);
		System.out.println(num * num);

	}

	/**
	 * @date 2017年6月13日 上午9:41:46
	 * @Description: TODO(程序中设置断言) 选择菜单：Run ---> Run Configurations...---> 选择
	 *               Arguments 选项卡 在 VM arguments 文本框中输入： -ea 注意：中间没有空格，如果输入 -da
	 *               表示禁止断言。 然后关闭该窗口，然后保存就开启了断言。
	 */

	@Test
	public void ThrowDemo3() {
		boolean isOpen = false;
		assert isOpen = true; // 如果开启了断言，会将isOpen的值改为true
		System.out.println(isOpen);// 打印是否开启了断言
		int x = 10;
		assert x == 30 : "x是否等于30";//
		System.out.println(x);
	}

	/**
	 * @date 2017年6月13日 上午9:56:08
	 * @Description: TODO(设置自定义异常)
	 */
	public ThrowDemo(String arg) {
		super(arg);
	}

	@Test
	public void ThrowDemoDoIt() throws Exception {
		throw new ThrowDemo("抛出异常");
	}
}
