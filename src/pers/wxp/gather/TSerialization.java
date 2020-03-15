package pers.wxp.gather;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wxp
 *Serializable:�ṩ��һ�ֳ־û�����ʵ��Ļ���.
 */
public class TSerialization implements Serializable {
	/**
	 *Ϊ����һ���ض������һ�����Ϲر�serialization�������������ǰ���Ϲؼ���transient�� 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private transient String psw;//�����Ϊtransient�������ڶ������л���ʱ�򲻻ᱻ���档

	public TSerialization(String name, String psw) {
		this.name = name;
		this.psw = psw;
	}

	public String toString() {
		return "name=" + name + ", psw=" + psw;
	}

	public static void main(String[] args) {
		TSerialization userInfo = new TSerialization("����", "123456");
		System.out.println(userInfo);
		try {
			// ���л���������Ϊtransient������û�б����л�
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
			o.writeObject(userInfo);
			o.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			// ���¶�ȡ����
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));
			TSerialization readUserInfo = (TSerialization) in.readObject();
			// ��ȡ��psw������Ϊnull
			System.out.println(readUserInfo.toString());
		} catch (Exception e) { 
			
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
