package pers.wxp.gather;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author wxp
 *
 */
public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		map1.put("0", null);
		map1.get("0").toString();
		map1.put("1", "aaa1");
		map1.put("2", "bbb2");
		map2.put("10", "aaaa10");
		map2.put("11", "bbbb11");
		// 根据键 "1" 取得值："aaa1"
		System.out.println("map1.get(\"1\")=" + map1.get("1"));
		// 根据键 "1" 移除键值对"1"-"aaa1"
		System.out.println("map1.remove(\"1\")=" + map1.remove("1"));
		System.out.println("map1.get(\"1\")=" + map1.get("1"));
		map1.putAll(map2);// 将map2全部元素放入map1中
		map2.clear();// 清空map2
		System.out.println("map1 IsEmpty?=" + map1.isEmpty());
		System.out.println("map2 IsEmpty?=" + map2.isEmpty());
		System.out.println("map1 中的键值对的个数size = " + map1.size());
		System.out.println("KeySet=" + map1.keySet());// set
		System.out.println("values=" + map1.values());// Collection
		System.out.println("entrySet=" + map1.entrySet());
		System.out.println("map1 是否包含键：11 = " + map1.containsKey("11"));
		System.out.println("map1 是否包含值：aaa1 = " + map1.containsValue("aaa1"));
	}

	/**
	 * HashMap<>如果Map中已经存在相同的键的键值对的话， 那么就把新的值覆盖老的值，并把老的值返回给方法的调用者。
	 * 如果不存在键，那么就返回null 。
	 */
	@Test
	public void TypeHashMap() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(1, 2);//存在重复的key值
		map.put(3, 1);
		map.put(4, 1);
		System.out.println("map.get(\"1\")=" + map.get(1));
		System.out.println("map.get(\"5\")=" + map.get(5));//不存在则返回null
		Map<Integer, Object> map1 = new HashMap<>();
		map1.put(1, 1);
		map1.put(2, 1);
		map1.put(3, 1);
		map1.put(4, 1);
		map1.put(5, "123");
		System.out.println("map1.get(\"1\")=" + map1.get(5));
		map1.putAll(map);
	}
	@Test
	public void TypeHashTable() {
		Map<Integer, Integer> map = new Hashtable<>();
		map.put(1, 1);
		map.put(1, 2);//存在重复的key值
		map.put(3, 1);
		map.put(4, 1);
		System.out.println("map.get(\"1\")=" + map.get(1));
		System.out.println("map.get(\"5\")=" + map.get(5));//不存在则返回null
		map.size();
		for (int i = 0; i < map.size(); i++) {
			System.out.println(map.get(i));
		}
		Map<Integer, Object> map1 = new Hashtable<>();
		map1.put(1, 1);
		map1.put(2, 1);
		map1.put(3, 1);
		map1.put(4, 1);
		map1.put(5, "123");
		System.out.println("map1.get(\"1\")=" + map1.get(5));
		map1.putAll(map);
	}
	@Test
	public void TypeHashTable1() {
		try{
			Map<Integer, Integer> map = null;
			map.get(2);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
