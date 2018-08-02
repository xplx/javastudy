package pers.wxp.gather;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<Dog, Integer> map1 = new HashMap<Dog, Integer>();

		map1.put(new Dog("Kitty"), 20);
		map1.put(new Dog("Paul"), 10);

		System.out.println(map1.get(new Dog("Kitty"))); // null
		String hashCode = "hello";
		System.out.println("hello".hashCode());
		System.out.println("hello1".hashCode());
		System.out.println("hello22134".hashCode());

		String test = "test";
		test.hashCode();
	}
}
