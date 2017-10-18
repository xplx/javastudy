package pers.wxp.gather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wxp
 * @date 2017年10月16日 下午5:47:33
 * @Description: TODO()
 */
public class ListTestLoop {
	private static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		ListTestLoop mapTest = new ListTestLoop();
		mapTest.initList(list);
		mapTest.foreach(list);
		mapTest.forlist(list);
		mapTest.iteratorList(list);
	}

	// list 集合中添加10万条数据
	public List initList(List<String> list) {
		int i = 0;
		int num = 6000000;
		for (i = 0; i < num; i++) {
			list.add("list" + i);
		}
		return list;
	}
	// list 集合遍历 foreach

	/** 
	* @Description: TODO(内部调用第一种,因此比Iterator 慢,这种循环方式还有其他限制, 不建议使用它，最耗时。) 
	* @param: @param list    
	* @return void     
	*/
	public void foreach(List<String> list) {
		long start = System.currentTimeMillis();
		for (String data : list) {
			String value = data;
		}

		long end = System.currentTimeMillis();
		long count = end - start;
		System.out.println("foreach 循环时间" + count);
	}

	// list集合遍历 for
	public void forlist(List<String> list) {
		long start = System.currentTimeMillis();
		int i = 0;
		for (i = 0; i < list.size(); i++) {
			String value = list.get(i);
		}
		long end = System.currentTimeMillis();
		long count = end - start;
		System.out.println("for list.size() 遍历时间" + count);
	}

	// Iterator 遍历循环
	public void iteratorList(List<String> list) {
		long start = System.currentTimeMillis();
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String value = it.next();
		}
		long end = System.currentTimeMillis();
		long count = end - start;
		System.out.println("iterator 遍历时间" + count);
	}
}
