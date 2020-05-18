package pers.wxp.Serial;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wxp
 * @date 2017年9月14日 下午5:03:16
 * @Description: TODO(测试实体类)
 */
class Person implements Externalizable {
	String userName;
	String password;
	String age;
	//添加这么一个成员变量
	private String address;

	public Person(String userName, String password, String age) {
		super();
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	public Person() {
		super();
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 序列化操作的扩展类 定义了哪些属性可以序列化，
	 * 哪些不可以序列化，所以，对象在经过这里就把规定能被序列化的序列化保存文件，不能序列化的不处理，然后在反序列的时候自动调用
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// 增加一个新的对象
		Date date = new Date();
		out.writeObject(userName);
		out.writeObject(password);
		out.writeObject(date);
	}

	/**
	 * 反序列化的扩展类
	 * 用readExternal()方法，根据序列顺序挨个读取进行反序列，并自动封装成对象返回，然后在测试类接收，就完成了反序列
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// 注意这里的接受顺序是有限制的哦，否则的话会出错的
		// 例如上面先write的是A对象的话，那么下面先接受的也一定是A对象...
		userName = (String) in.readObject();
		password = (String) in.readObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) in.readObject();
		System.out.println("反序列化后的日期为:" + sdf.format(date));

	}

	@Override
	public String toString() {
		// 注意这里的年龄是不会被序列化的，所以在反序列化的时候是读取不到数据的
		return "用户名:" + userName + "密 码:" + password + "年龄:" + age;
	}
}

/**
 * 序列化和反序列化的相关操作类
 * 
 */
class Operate {
	/**
	 * 序列化方法
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void serializable(Person person) throws FileNotFoundException, IOException {
		// 创建文件
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serializable.txt"));
		outputStream.writeObject(person);
	}

	/**
	 * 反序列化的方法
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public Person deSerializable() throws FileNotFoundException, IOException, ClassNotFoundException {
		// 读取文件
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializable.txt"));
		return (Person) ois.readObject();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Operate operate = new Operate();
		Person person = new Person("小浩", "123456", "20");
		System.out.println("为序列化之前的相关数据如下:\n" + person.toString());
		operate.serializable(person);
		Person newPerson = operate.deSerializable();
		System.out.println("-------------------------------------------------------");
		System.out.println("序列化之后的相关数据如下:\n" + newPerson.toString());
	}
}
