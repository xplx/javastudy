package pers.wxp.type;

import org.junit.Test;

public class StringDemo {
	/**
	 * @Description: TODO(测试string和stringbuffer比较)
	 * @param:
	 * @return void
	 */
	@Test
	public void strAndSBCompare() {
		//初始化空对象
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("tcp");
		//错误的赋值方式
		//stringBuffer = "abc";
		
		//不存在继承关系，无法进行强转
		//StringBuffer s = (StringBuffer)"abc"; 
		
		//初始化为abc
		StringBuffer sb1 = new StringBuffer("abc");
		
		String string1 = "hello";
		
		//string 转换成stringbuffer
		StringBuffer sb2 = new StringBuffer(string1); //String转换为StringBuffer
		System.out.println(sb2);
		
		//stringbuffer 转换成string
		String s1 = sb1.toString(); //StringBuffer转换为String
		System.out.println(s1);
	}
	
	/** 
	* @Description: TODO(stringbuffer使用,StringBuffer类中的方法主要偏重于对于字符串的变化，例如追加、插入和删除等，这个也是StringBuffer和String类的主要区别) 
	* @param:     
	* @return void     
	*/
	@Test
	public void stringbufferUse() {
		//将字符串追加到末尾
		StringBuffer sb = new StringBuffer();
		String user = "test";
		String pwd = "123";
		sb.append("select * from userInfo where username=").append(user).append(" and pwd=").append(pwd);
		System.out.println(sb);
		
		//删除指定的索引位置
		StringBuffer sb1 = new StringBuffer("Test");
		sb1. deleteCharAt(1);
		System.out.println(sb1);
		
		//插入指定的位置
		StringBuffer sb2 = new StringBuffer("TestString");
		sb2.insert(4,false);
		System.out.println(sb2);
		
		//颠倒指定字符串
		StringBuffer sb3 = new StringBuffer("abc");
		sb3.reverse();
		System.out.println(sb3);
		
		//修改指定位置字符串
		StringBuffer sb4 = new StringBuffer("abc");
		sb4.setCharAt(1,'D');
		System.out.println(sb4);
	}
	
	
	
}
