package pers.wxp.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectTest {
	private String proprety = null;

	public static void main(String[] args) throws Exception {
		// getClassName();
		ReflectClass();
		getDeclaredFieldTest();
	}

	/**
	 * getClass()返回的是类的对象
	 */
	public static void getClassName() {
		ReflectTest testReflect = new ReflectTest();// 正着操作实例化
		System.out.println(testReflect.getClass().getName());// 反着操作
		System.out.println(testReflect.getClass().getPackage());
		System.out.println(testReflect.getClass().getName());
		System.out.println(testReflect.getClass().getName());
	}

	/**
	 * 三种不同方式获取class类对象的方式
	 */
	public static void ReflectClass() {
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		try {
			class1 = Class.forName("pers.wxp.reflect.ReflectTest");// 获取类对象
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// 打印错误
		}
		class2 = new ReflectTest().getClass();// ��̬ʵ�����
		class3 = ReflectTest.class;// Hibernate常用此方式
		System.out.println("class1  " + class1.getName());
		System.out.println("class2  " + class2.getName());
		System.out.println("class3  " + class3.getName());
	}

	/**
	 * 通过反射实例化对象，获取对象属性值
	 * 
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static void getDeclaredFieldTest() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {

		Class<?> clazz = Class.forName("pers.wxp.reflect.ReflectTest");// 获取对象
		Object obj = clazz.newInstance();// 实例化对象ֵ
		Field field = clazz.getDeclaredField("proprety");//取得类中的成员
		field.setAccessible(true);//解除封装
		field.set(obj, "Java实例化对象");//给属性设置
		System.out.println(field.get(obj));

	}

	public static void ArrayListTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Method method = list.getClass().getMethod("add", Object.class);
		method.invoke(list, "JavaList");
		System.out.println(list.get(0));
	}
	public static void reflectTest() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			Class clazz = loader.loadClass("pers.wxp.reflect.ReflectTest");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
