package pers.wxp.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wxp
 * @date 2017年9月13日 上午8:49:55
 * @Description: TODO(实验spring的反射机制)
 */
public class TestReflect1 {
	String fileds = "类属性";
	public static void main(String[] args) throws Exception {
		//// 根据类的全路径进行类加载，返回该类的Class对象
		Class<?> clazz = Class.forName("pers.wxp.reflect.TestReflect1");
		// 利用得到的Class对象的自审，返回方法对象集合( Java的反射机制它知道类的基本结构，这种对Java类结构探知的能力，我们称为Java类的“自审”。)
		Method[] method = clazz.getDeclaredMethods();
		for (Method method2 : method) {
			System.out.println(method2);
		}
		// 利用得到的Class对象的自审，返回属性对象集合
		Field[] field = clazz.getDeclaredFields();
		for (Field me : field) { // 遍历该类属性的集
			System.out.println(me.toString());// 打印属性信息
		}
		 Method method1 = clazz.getMethod("reflect1");// 获取类中指定的方法
		 //实例化类对象
		 method1.invoke(clazz.newInstance());
		 method1 = clazz.getMethod("reflect2", int.class, String.class);
		 //调用函数
		 method1.invoke(clazz.newInstance(), 20, "调用函数");
	}

	public void reflect1() {
		System.out.println("Java 实验1.");
	}

	public void reflect2(int age, String name) {
		System.out.println("Java 实验2.");
		System.out.println("age -> " + age + ". name -> " + name);
	}
}
