package pers.wxp.gather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ListDemo {

	/**
	 * 不要在 foreach 循环里进行元素的 remove/add 操作。 remove 元素请使用 Iterator方式，
	 */
	@Test
	public void removeDemo() {
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");

//		for (String temp : a) {
//			if ("2".equals(temp)) {// 这里使用equals时，使用已知的值去相等未知的值，免得出现错误。
//				a.remove(temp);
//			}
//		}
//		System.out.println(a);
		
		Iterator<String> it = a.iterator();
		while (it.hasNext()) {
			String temp = it.next();
			if (temp == "2") {
				it.remove();
			}
		}
		System.out.println(a);
	}

}
