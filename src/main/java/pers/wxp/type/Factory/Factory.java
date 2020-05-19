package pers.wxp.type.Factory;

/**
 * @author wxp
 * @date 2018年1月31日 上午10:16:41
 * @Description: TODO( 那么怎么能获得这些程序员定义的对象呢？在工厂模式里，单独定义一个工厂类来实现对象的生产，注意这里返回的接口对象。)
 */
public class Factory {
	// 创建私有的静态的Properties对象
	// private static Properties pro = new Properties();
	// // 静态代码块
	// static {
	// try {
	// // 加载配置文件
	// pro.load(new FileInputStream("file.txt"));
	//
	// } catch (Exception e) {
	//
	// e.printStackTrace();
	// }
	// }
	/**
	 * 单例模式，保证该类只有一个对象
	 */
	private static Factory factory = new Factory();

	private Factory() {
	}

	public static Factory getFactory() {

		return factory;

	}

	/**
	 * 本方法为公有方法，用于生产接口对象
	 * 
	 * @return InterfaceTest接口对象
	 */

	public InterfaceTest getInterface(String filePath) {
		InterfaceTest interfaceTest = null;// 定义接口对象
		try {
			// 根据键，获得值，这里的值是类的全路径
			// String classInfo = pro.getProperty("test");
			// 利用反射，生成Class对象
			Class c = Class.forName(filePath);
			// 获得该Class对象的实例
			Object obj = c.newInstance();
			// 将Object对象强转为接口对象
			interfaceTest = (InterfaceTest) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回接口对象
		return interfaceTest;
	}
}
