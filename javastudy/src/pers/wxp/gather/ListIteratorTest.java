package pers.wxp.gather;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;



public class ListIteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		System.out.println("下标0开始：" + list.listIterator(0).next());// next()
		System.out.println("下标1开始:" + list.listIterator(1).next());
		System.out.println("子List 1-3:" + list.subList(1, 3));// 子列表
		ListIterator<String> it = list.listIterator();// 默认从下标0开始
		// 隐式光标属性add操作 ,插入到当前的下标的前面
		it.add("sss");
		while (it.hasNext()) {
			System.out.println("next Index=" + it.nextIndex() + ",Object=" + it.next());
		}
		// set属性
		ListIterator<String> it1 = list.listIterator();
		it1.next();
		it1.set("ooo");
		ListIterator<String> it2 = list.listIterator(list.size());// 下标
		while (it2.hasPrevious()) {
			System.out.println("previous Index=" + it2.previousIndex() + ",Object=" + it2.previous());
		}
	}

}
