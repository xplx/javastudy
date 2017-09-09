package pers.wxp.list;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wxp
 *Serializable:提供了一种持久化对象实例的机制.
 */
public class TSerialization implements Serializable {
	/**
	 *为了在一个特定对象的一个域上关闭serialization，可以在这个域前加上关键字transient。 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private transient String psw;//被标记为transient的属性在对象被序列化的时候不会被保存。

	public TSerialization(String name, String psw) {
		this.name = name;
		this.psw = psw;
	}

	public String toString() {
		return "name=" + name + ", psw=" + psw;
	}

	public static void main(String[] args) {
		TSerialization userInfo = new TSerialization("张三", "123456");
		System.out.println(userInfo);
		try {
			// 序列化，被设置为transient的属性没有被序列化
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
			o.writeObject(userInfo);
			o.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			// 重新读取内容
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));
			TSerialization readUserInfo = (TSerialization) in.readObject();
			// 读取后psw的内容为null
			System.out.println(readUserInfo.toString());
		} catch (Exception e) { 
			
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
