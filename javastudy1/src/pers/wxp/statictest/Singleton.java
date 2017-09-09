package pers.wxp.statictest;

/**
 * @author 作者 E-mail:
 * @date 创建时间：2017年6月12日 下午1:36:09
 * @Description: TODO(设置单列模式)
 * @version 1.0
 * @parameter
 */
public class Singleton {

	/**
	 * 控制唯一实例化对象
	 */
	final private static Singleton instance = new Singleton();

	/**
	 * @date 2017年6月12日 下午1:38:45
	 * @Description: TODO(单列模式必须设置一个私有化的构造函数)
	 */
	private void Singleton() {

	}

	/**
	 * @date 2017年6月12日 下午1:51:29
	 * @Description: TODO(获取实例化对象)
	 * @return
	 */
	public static Singleton getInstance() {
		return instance;
	}

	public void printf() {
		System.out.println("hello word");
	}
}

/**
 * @author wuxiaopeng
 * @date 2017年6月12日 下午1:52:07
 * @Description: TODO(实例化单列模式测试)
 * 
 */
class DemoTest {
	public static void main(String[] args) {
		while (true) {
			Singleton singleton = null;
			singleton = Singleton.getInstance();
			singleton.printf();
		}
	}
}
