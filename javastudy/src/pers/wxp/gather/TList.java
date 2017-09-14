package pers.wxp.gather;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * @author wxp List���÷� List����List�ӿ��Լ�List�ӿڵ�����ʵ���ࡣ ��ΪList�ӿ�ʵ����Collection�ӿڣ�
 *         ����List�ӿ�ӵ��Collection�ӿ��ṩ�����г��÷�����
 *         ����ΪList���б����ͣ�����List�ӿڻ��ṩ��һЩ�ʺ�������ĳ��÷���
 */

public class TList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @author wxp 
	 * add(int index, Object obj):��ָ������λ����Ӷ��� 
	 * set(int index, Object obj):�޸�ָ������λ�õĶ���
	 *   
	 */
	@Test
	public void AddSet() {
		String a = "A", b = "B", c = "C", d = "D", e = "E";
		List<String> list = new LinkedList<String>();
		list.add(a);
		list.add(e);
		list.add(d);
		list.set(1, b);// ������λ��Ϊ1�Ķ���e�޸�Ϊ����b
		list.add(2, c);// ������c��ӵ�����λ��Ϊ2��λ��
		Iterator<String> it = list.iterator();//ʹ�õ��ʽ������ѭ��
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		for (int i = 0; i < list.size(); i++) {//ʹ��forѭ���������
			System.out.println(list.get(i));   // ����get(int index)�������ָ������λ�õĶ���
			}

	}

}
