package pers.wxp.gather;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<String>();
		collection.add("s1");
		collection.add("s2");
		collection.add("s3");
		Iterator<String> iterator = collection.iterator();// 得到一个迭代器
		while (iterator.hasNext()) {// 遍历hasNext()检查序列中是否有元素
			Object element = iterator.next();//next() 获得集合序列的中的下一个元素,返回next的是object于是元素  
			System.out.println("iterator = " + element);//返回集合的元素
		}
		if (collection.isEmpty())
			System.out.println("collection is Empty!");
		else
			System.out.println("collection is not Empty! size=" + collection.size());
		Iterator<String> iterator2 = collection.iterator();
		while (iterator2.hasNext()) {// 移除元素
			Object element = iterator2.next();
			System.out.println("remove: " + element);
			iterator2.remove();
		}
		Iterator<String> iterator3 = collection.iterator();
		if (!iterator3.hasNext()) {// 察看是否还有元素
			System.out.println("还有元素");
		}
		if (collection.isEmpty())
			System.out.println("collection is Empty!");
		// 使用collection.isEmpty()方法来判断
	}
}
