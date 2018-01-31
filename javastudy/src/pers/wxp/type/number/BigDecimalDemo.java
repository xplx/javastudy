package pers.wxp.type.number;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author wxp
 * @date 2018年1月10日 上午10:30:15
 * @Description: TODO( BigDecimal 由任意精度的整数非标度值 和32 位的整数标度 (scale) 组成。如果为零或正数，则标度是小数点后的位数。如果为负数，则将该数的非标度值乘以 10 的负scale 次幂。因此，BigDecimal表示的数值是(unscaledValue ×
 *               10-scale)。)
 */
public class BigDecimalDemo {
	/**
	 * @Description: TODO(主要测试参数类型为double和String的两个常用构造函数)
	 * @param:
	 * @return void
	 */
	@Test
	public void bigDecimalTest() {
		Double double1 = 1.22;
		// 参数类型为double的构造方法的结果有一定的不可预知性.
		BigDecimal aDouble = new BigDecimal(double1);
		System.out.println("construct with a double value: " + aDouble);
		String string1 = "1.22";
		// String 构造方法是完全可预知的,因此：通常建议优先使用String构造方法
		BigDecimal aString = new BigDecimal(string1);
		System.out.println("construct with a String value: " + aString);
	}

	@Test
	public void add() {
		// 加法操作
		BigDecimal a = new BigDecimal("1.22");
		System.out.println("construct with a String value: " + a);
		BigDecimal b = new BigDecimal("2.22");
		// 这里记得赋值
		a = a.add(b);
		System.out.println("aplus b is : " + a);
	}

	/**
	 * 提供精确的减法运算。
	 */
	@Test
	public void sub() {
		BigDecimal b1 = new BigDecimal(Double.toString(12.12));
		BigDecimal b2 = new BigDecimal(Double.toString(5.66));
		b1 = b1.subtract(b2);
		System.out.println("subtract:" + b1);
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @return 两个参数的积
	 */
	@Test
	public void mul() {
		BigDecimal b1 = new BigDecimal("12.12");
		BigDecimal b2 = new BigDecimal("13.12");
		b1 = b1.multiply(b2);
		System.out.println("multiply:" + b1);
	}

	/**
	 * 提供精确的乘法运算。 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @return 两个参数的除法
	 */
	@Test
	public void div() {
		BigDecimal b1 = new BigDecimal("12.12");
		BigDecimal b2 = new BigDecimal("13.12");
		b1 = b1.divide(b2, 4, BigDecimal.ROUND_HALF_UP);
		System.out.println("divide:" + b1);
		//除以100
		String rechargeMoneyByYuan = new BigDecimal("1000").divide(new BigDecimal(100)).toString();// 转换成元
		System.out.println(rechargeMoneyByYuan);
	}
}
