package pers.wxp.type;

/**
 * @author wxp
 * @date 2017年10月13日 上午10:29:09
 * @Description: TODO(JAVA中对于需要频繁new的对象的一个优化的方法)
 * @study:(各位应该也知道，当一个类存在继承关系时，你创建一个子类的对象时，如果在没有明确指定的情况下，子类是会隐式的去调用父类的无参构造的,假设，
 * 我们需要频繁创建的对象，是一个继承关系比较深的类的话，调用构造函数的开销不容小窥啊。)
 */
public class ReduceNew {
	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis();

		// 采用clone方法，clone的最大特点就是，不会去调用任何构造方法
		for (int i = 0; i < 100; i++) {
			Person.getOnePerson();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("采用clone的方法，一共花费的时间：" + (endTime - beginTime));

		beginTime = System.currentTimeMillis();

		// 采用普通方法
		for (int i = 0; i < 100; i++) {
			new Person();
		}

		endTime = System.currentTimeMillis();
		System.out.println("采用new的方法，一共花费的时间：" + (endTime - beginTime));
	}
}

class TestA {
	private String aa;
	private static int count = 0;

	public TestA() {
		// 模拟一下耗时操作
		try {
			Thread.sleep(10);
			count++;
			System.out.println("TestA:" + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

}

class TestB extends TestA {
	private String bb;
	private static int count = 0;

	public TestB() {
		// 模拟一下耗时操作
		try {
			count++;
			Thread.sleep(10);
			System.out.println("TestB:" + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getBb() {
		return bb;
	}

	public void setBb(String bb) {
		this.bb = bb;
	}

}

class Person extends TestB implements Cloneable {
	private String id;
	private String name;
	private static Person person = new Person();
	private int[] temp = null;

	// 这里理应设置为private的，但是为了在上面测试方便，这里就将其设置为public了
	// 但是，在真正开发中时，为了避免误导开发人员，应该将构造函数私有化
	public Person() {

	};

	public static Person getOnePerson() {
		try {
			return (Person) person.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 模拟有参构造方法
	public static Person getOnePersonWithInitName(String name) {
		try {
			Person tempPerson = (Person) person.clone();
			tempPerson.name = name;
			return tempPerson;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getTemp() {
		return temp;
	}

	public void setTemp(int[] temp) {
		this.temp = temp;
	}

}