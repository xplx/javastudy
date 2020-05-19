package pers.wxp.type;

/**
 * @author wxp
 * @date 2018年1月30日 下午3:45:32
 * @Description: TODO(结论：finally中的代码比return 和break语句后执行)
 */
public class FinallyDemo {
	public static void main(String args[]) {

		FinallyDemo t = new FinallyDemo();

		int b = t.get();

		System.out.println(b);

	}

	public int get() {// 普通方法，创建对象调用

		try {
			return 1;
			//finally是异常处理语句结构的一部分，表示总是执行。
		} finally {
			return 2;
		}

	}
}
