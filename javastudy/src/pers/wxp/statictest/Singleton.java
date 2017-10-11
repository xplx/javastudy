package pers.wxp.statictest;

/**
 * @author wxp
 * @date 2017年9月14日 下午4:04:26
 * @Description: TODO(单例模式)
 */
public class Singleton {

	final private static Singleton instance = new Singleton();

	private void Singleton() {

	}

	/**
	 * @Description: TODO(静态方法只构建一次)
	 * @param: @return
	 * @return Singleton
	 */
	public static Singleton getInstance() {
		return instance;
	}

	public void printf() {
		System.out.println("hello word");
	}
}

class DemoTest {
	public static void main(String[] args) {
		while (true) {
			Singleton singleton = null;
			singleton = Singleton.getInstance();
			singleton.printf();
		}
	}
}
