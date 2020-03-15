package pers.wxp.type;

import org.junit.Test;

/**
 * @author wxp
 * @date 2018年1月30日 下午2:48:57
 * @Description: TODO(使用final关键字修饰一个变量时，是引用不能变，还是引用的对象不能变？ 答:使用final关键字修饰一个变量时，是指引用变量不能变，引用变量所指向的对象中的内容还是可以改变的。)
 * final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。 典型案例内部类要访问局部变量，局部变量必须定义成final类型。
 */
public class FinalDemo {
	@Test
	public void finalDemo1() {
		final StringBuffer a = new StringBuffer("immutable");
		System.out.println(a);
		// 执行如下语句将报告编译期错误
		// a=new StringBuffer("");
		// 但是执行如下语句则可以通过编译：
		a.append(" broken!");
		System.out.println(a);
	}

	public static void main(String[] args) {

		System.out.println(new FinalDemo().test());
	}

	
	/** 
	* @Description: TODO(try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后? ) 
	* @param: @return    
	* @return int     
	*/
	private static int test() {
		int x = 1;
		try {
			return x;
		} finally {
			//被执行，但是值没变，需要有返回值时，值才会增加，
			++x;
			//去掉return时值不变。
			return x;
		}

	}
}
