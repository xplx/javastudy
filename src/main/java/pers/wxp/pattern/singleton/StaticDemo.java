package pers.wxp.pattern.singleton;

/**
 * @author wxp
 * @date 2017年9月14日 下午3:55:55
 * @Description: TODO(static{ 和 }之间的代码被称为静态初始化器。它只有在第一次加载类时运行。)
 */
public class StaticDemo {
	static int count;
	static {
		// This is a static initializers. Run only when Class is first
		// loaded.
		// Only static variables can be accessed
		System.out.println("Static Initializer");
		count++;
		System.out.println("Count when Static Initializer is run is " + count);
	}

    //每次创建类的实例时，实例初始化器中的代码都会运行
	{
		// This is an instance initializers. Run every time an object is
		// created.
		// static and instance variables can be accessed
		System.out.println("Instance Initializer");
		count = count + 1;
		System.out.println("Count when Instance Initializer is run is " + count);
	}

	/**
	 * @Description: TODO()
	 * @param: @param
	 *             args
	 * @return void
	 */
	public static void main(String[] args) {
		// 虽然创建了三个实例，但静态初始化器只运行一次
		StaticDemo example = new StaticDemo();
		StaticDemo example2 = new StaticDemo();
		StaticDemo example3 = new StaticDemo();
	}
}
