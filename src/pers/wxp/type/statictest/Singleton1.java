package pers.wxp.type.statictest;

public class Singleton1 {
	/*
	 * 注意这是private私有的构造方法， 只供内部调用 外部不能通过new的方式来生成该类的实例
	 */
	private Singleton1() {

	}

	/*
	 * 在自己内部定义自己一个实例，是不是很奇怪？ 定义一个静态的实例，保证其唯一性
	 */
	private static Singleton1 instance = new Singleton1();

	// 这里提供了一个供外部访问本class的静态方法，可以直接访问
	public static Singleton1 getInstance() {
		return instance;
	}

	public static void main(String[] args) {

		// 这样的调用不被允许，因为构造方法是私有的。

		// Singleton x=new Singleton();

		// 得到一个Singleton类实例

		Singleton1 x = Singleton1.getInstance();

		// 得到另一个Singleton类实例

		Singleton1 y = Singleton1.getInstance();

		// 比较x和y的地址，结果为true。说明两次获得的是同一个对象

		System.out.println(x == y);

	}
}
