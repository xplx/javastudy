package pers.wxp.gather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListDemo {

	@Test
	public void removeDemo() {
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");

		Iterator<String> it = a.iterator();
		while (it.hasNext()) {
			String temp = it.next();
			if (temp == "2") {
				it.remove();
			}
		}
		System.out.println(a);
		List l = new ArrayList<>();
		List ll = new LinkedList();
	}
}
