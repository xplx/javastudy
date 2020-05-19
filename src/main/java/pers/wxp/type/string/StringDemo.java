package pers.wxp.type.string;

import org.junit.Test;

public class StringDemo {
	/**
	 * @Description: TODO(����string��stringbuffer�Ƚ�)
	 * @param:
	 * @return void
	 */
	@Test
	public void strAndSBCompare() {
		//��ʼ���ն���
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("tcp");
		//����ĸ�ֵ��ʽ
		//stringBuffer = "abc";
		
		//�����ڼ̳й�ϵ���޷�����ǿת
		//StringBuffer s = (StringBuffer)"abc"; 
		
		//��ʼ��Ϊabc
		StringBuffer sb1 = new StringBuffer("abc");
		
		String string1 = "hello";
		
		//string ת����stringbuffer
		StringBuffer sb2 = new StringBuffer(string1); //Stringת��ΪStringBuffer
		System.out.println(sb2);
		
		//stringbuffer ת����string
		String s1 = sb1.toString(); //StringBufferת��ΪString
		System.out.println(s1);
	}
	
	/** 
	* @Description: TODO(stringbufferʹ��,StringBuffer���еķ�����Ҫƫ���ڶ����ַ�ı仯������׷�ӡ������ɾ��ȣ����Ҳ��StringBuffer��String�����Ҫ���) 
	* @param:     
	* @return void     
	*/
	@Test
	public void stringbufferUse() {
		//���ַ�׷�ӵ�ĩβ
		StringBuffer sb = new StringBuffer();
		String user = "test";
		String pwd = "123";
		sb.append("select * from userInfo where username=").append(user).append(" and pwd=").append(pwd);
		System.out.println(sb);
		
		//ɾ��ָ��������λ��
		StringBuffer sb1 = new StringBuffer("Test");
		sb1. deleteCharAt(1);
		System.out.println(sb1);
		
		//����ָ����λ��
		StringBuffer sb2 = new StringBuffer("TestString");
		sb2.insert(4,false);
		System.out.println(sb2);
		
		//�ߵ�ָ���ַ�
		StringBuffer sb3 = new StringBuffer("abc");
		sb3.reverse();
		System.out.println(sb3);
		
		//�޸�ָ��λ���ַ�
		StringBuffer sb4 = new StringBuffer("abc");
		sb4.setCharAt(1,'D');
		System.out.println(sb4);
	}
	
	
	
}
