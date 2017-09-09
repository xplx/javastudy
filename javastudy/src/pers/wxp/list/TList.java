package pers.wxp.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * @author wxp List的用法 List包括List接口以及List接口的所有实现类。 因为List接口实现了Collection接口，
 *         所以List接口拥有Collection接口提供的所有常用方法，
 *         又因为List是列表类型，所以List接口还提供了一些适合于自身的常用方法
 */

public class TList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @author wxp 
	 * add(int index, Object obj):向指定索引位置添加对象 
	 * set(int index, Object obj):修改指定索引位置的对象
	 *   
	 */
	@Test
	public void AddSet() {
		String a = "A", b = "B", c = "C", d = "D", e = "E";
		List<String> list = new LinkedList<String>();
		list.add(a);
		list.add(e);
		list.add(d);
		list.set(1, b);// 将索引位置为1的对象e修改为对象b
		list.add(2, c);// 将对象c添加到索引位置为2的位置
		Iterator<String> it = list.iterator();//使用迭代方式来遍历循环
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		for (int i = 0; i < list.size(); i++) {//使用for循环来遍历集合
			System.out.println(list.get(i));   // 利用get(int index)方法获得指定索引位置的对象
			}

	}

}
