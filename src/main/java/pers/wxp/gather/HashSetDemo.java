package pers.wxp.gather;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wxp
 *Set 成员不能重复
 */
public class HashSetDemo {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		if (set1.add("a")) {//添加成功
			System.out.println("1 add true");
		}
		if (set1.add("a")) {//添加失败
			System.out.println("2 add true");
		}		
		set1.add("000");//添加对象到Set集合中
		set1.add("111");
		set1.add("222");
		System.out.println("集合set1的大小："+set1.size());
		System.out.println("集合set1的内容："+set1);
		set1.remove("000");//从集合set1中移除掉 "000" 这个对象
		System.out.println("集合set1移除 000 后的内容："+set1);
		System.out.println("集合set1中是否包含000 ："+set1.contains("000"));
		System.out.println("集合set1中是否包含111 ："+set1.contains("111"));
		Set<String> set2=new HashSet<String>();
		set2.add("111");
		set2.addAll(set1);//将set1 集合中的元素全部都加到set2中
		System.out.println("集合set2的内容："+set2);
		set2.clear();//清空集合 set1 中的元素
		System.out.println("集合set2是否为空 ："+set2.isEmpty());
		Iterator<String> iterator = set1.iterator();//得到一个迭代器
		while (iterator.hasNext()) {//遍历
			Object element = iterator.next();
			System.out.println("iterator = " + element);
		}
		//将集合set1转化为数组
		Object s[]= set1.toArray();
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	}

}
