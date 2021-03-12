package pers.wxp.reflect;

import java.io.Serializable;

public class TestReflect implements Serializable {
	private static final long serialVersionUID = -2862585049955236662L;

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("pers.wxp.reflect.TestReflect");//��ȡ����
		// ȡ�ø���
		Class<?> parentClass = clazz.getSuperclass();
		System.out.println("clazz�ĸ���Ϊ��" + parentClass.getName());
		// clazz�ĸ���Ϊ�� java.lang.Object
		// ��ȡ���еĽӿ�
		Class<?> intes[] = clazz.getInterfaces();//��ȡ�ӿ���
		System.out.println("clazzʵ�ֵĽӿ��У�");
		for (int i = 0; i < intes.length; i++) {
			System.out.println((i + 1) + "��" + intes[i].getName());
		}
		// clazzʵ�ֵĽӿ��У�
		// 1��java.io.Serializable
	}
}
