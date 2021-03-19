package pers.wxp.pattern.singleton;

/**
 * @author wxp
 * @date 2017年9月14日 下午4:04:26
 * @Description: TODO(单例模式:单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例。)
 */
public class Singleton {
	/**************************
	 * 饱汉模式 begin
	 **************************************/
	// 第一种：饱汉模式:在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
	// 一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了，
	// （1）私有化构造方法
	// private void Singleton() {}
	// （2）创建私有静态当前对象，注意这是private 只供内部调用
	// final private static Singleton instance = new Singleton();

	// （3）返回当前对象，这里提供了一个供外部访问本class的静态方法，可以直接访问
	// public static Singleton getInstance() {
	// return instance;
	// }
	/***************************
	 * 饱汉模式 end 只有当调用getInstance的时候，才回去初始化这个单例。
	 **************************************/
	// (1)私有构造方法
	private void SingleTon() {
	};

	/**
	 * (2)创建静态对象为null
	 * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
	 */
	private volatile static Singleton instance;

	// (3)在getInstance方法上加上同步，表示防止两个线程同时进行对象的创建
	public static synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	// 双重检查锁定
	public static Singleton getInstanceTwo() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	/**************************
	 * 饿汉模式 begin
	 **************************************/

	/************************** 饿汉模式 end **************************************/

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
