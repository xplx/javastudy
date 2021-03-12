package pers.wxp.Serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wxp
 * @date 2017年9月14日 下午5:31:29
 * @Description: TODO(.java中的序列化时transient变量(这个关键字的作用就是告知JAVA我不可以被序列化)
 *               和静态变量不会被序列化(下面是一个测试的例子))
 */
class Student1 implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private transient String password;
	private static int count = 0;

	public Student1(String name, String password) {
		System.out.println("调用Student的带参的构造方法");
		this.name = name;
		this.password = password;
		count++;
	}

	public String toString() {
		return "人数: " + count + " 姓名: " + name + " 密码: " + password;
	}
}

class ObjectSerTest1 {
	public static void main(String args[]) {
		try {
			FileOutputStream fos = new FileOutputStream("test.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Student1 s1 = new Student1("张三", "12345");
			Student1 s2 = new Student1("王五", "54321");
			oos.writeObject(s1);
			oos.writeObject(s2);
			oos.close();
			FileInputStream fis = new FileInputStream("test.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student1 s3 = (Student1) ois.readObject();
			Student1 s4 = (Student1) ois.readObject();
			System.out.println(s3);
			System.out.println(s4);
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
