package pers.wxp.Reflect;

import java.lang.reflect.Method;

public class TestReflect1 {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("pers.wxp.Reflect.TestReflect1");// 取得类对象
		Method method = clazz.getMethod("reflect1");// 获取类中指定的方法
		method.invoke(clazz.newInstance());
		method = clazz.getMethod("reflect2", int.class, String.class);
		method.invoke(clazz.newInstance(), 20, "调用函数");
	}

	public void reflect1() {
		System.out.println("Java 实验1.");
	}

	public void reflect2(int age, String name) {
		System.out.println("Java 实验2.");
		System.out.println("age -> " + age + ". name -> " + name);
	}
}
