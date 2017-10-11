package pers.wxp.interview;

/**
 * @author wxp
 * @date 2017年9月14日 下午3:40:56
 * @Description: TODO(它能让你验证假设。如果断言失败（即返回false）,必须开启断言1.Run -> Run
 *               Configurations -> Arguments页签 -> VM
 *               arguments文本框中加上断言开启的标志:-enableassertions 或者-ea 就可以了）
 */
public class AssertDemo {
	private int computerSimpleInterest(int principal, float interest, int years) {
		try {
			assert (principal > 10);
		} catch (AssertionError e) {
			// TODO: handle exception
			return 0;
		}

		return 100;
	}

	public static void main(String[] args) {
		AssertDemo assertDemo = new AssertDemo();
		int ret = assertDemo.computerSimpleInterest(-1, 1, 1);
		System.out.println(ret);
	}
}
