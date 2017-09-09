package pers.wxp.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SetTest {
	public static void setTest() {
		String idd = "123";
		List<String> list = new ArrayList<String>();
		list.add(idd);
		Boolean flag = list.contains(idd);
		System.out.println(flag);
		list.add("1");
		list.add("1");
		list.add("2");
		list.add("2");
		System.out.println(list);
		// list.clear();
		System.out.println(list);
		Set<String> set = new HashSet<String>();
		set.addAll(list);
		System.out.println(set);
		List<String> listNew = new ArrayList<String>();
		listNew.addAll(set);
		System.out.println(listNew);
	}

	@Test
	public void differValues() {
		Set<String> set = new HashSet<String>();
		Set<String> set1 = new HashSet<String>();
		set.add("s");
		set.add("s1");
		set.add("s2");
		set.add("s3");
		set.add("s6");
		set1.add("s2");
		set1.add("s3");
		set1.add("s4");
		set1.add("s5");
		getDiffrent(set, set1);
		getDiffrent(set1, set);
		set.retainAll(set1);//
		set1.retainAll(set);//
		// System.out.println(set);
		// System.out.println(set1);

	}

	/**
	 * 获取两个List的不同元素
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public void getDiffrent(Set<String> set1, Set<String> set2) {
		long st = System.nanoTime();
		List<String> diff = new ArrayList<String>();
		List<String> diff1 = new ArrayList<String>();
		for (String str : set1) {
			if (!set2.contains(str)) {
				diff.add(str);
			} else {
				diff1.add(str);
			}
		}
		System.out.println(diff.size());
		System.out.println(diff1.size());
		System.out.println(diff);
		System.out.println(diff1);
		System.out.println("getDiffrent total times " + (System.nanoTime() - st));
	}
}
