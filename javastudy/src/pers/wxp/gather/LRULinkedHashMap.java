package pers.wxp.gather;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class LRULinkedHashMap {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	/* LRU这个算法就是把最近一次使用时间离现在时间最远的数据删除掉，而实现LruCache将会频繁的执行插入、删除等操作 */
	final int initialCapacity = 10;// 初始化容量
	float loadFactor = 0.75f;// 加载因子，一般是 0.75f
	boolean accessOrder = true;// 排序方式 false 基于插入顺序 true 基于访问顺序
	// Map<String, Integer> map = new LinkedHashMap<>(initialCapacity,
	// loadFactor, accessOrder);
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	Map<String, Integer> map = new LinkedHashMap(initialCapacity, loadFactor, accessOrder) {
		@Override
		protected boolean removeEldestEntry(Entry eldest) {
			return size() > initialCapacity;
		}
	};

	@Test
	public void LinkedHashMapTest() {
		// 我们容量定的10个，我们插入15个 我们发现最先插入的五个不见了，说明LRU算法起到效果了。
		for (int i = 0; i < 15; i++) {
			map.put(String.valueOf(i), i);
		}
		// 访问前顺序
		for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Integer> next = it.next();
			System.out.println("linkedMap--before-->" + next.getKey());
		}
		// 访问前顺序
		System.out.println("访问前顺序");
		for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Integer> next = it.next();
			System.out.println("linkedMap--before-->" + next.getKey());
		}
		// 模拟访问
		map.get("5");
		map.get("6");

		// 访问后数据
		System.out.println("访问后顺序");
		for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Integer> next = it.next();
			System.out.println("linkedMap--before-->" + next.getKey());
		}
		map.put("15", 15);
		// 访问后数据
		System.out.println("访问后顺序加载数据");
		for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Integer> next = it.next();
			System.out.println("linkedMap--before-->" + next.getKey());
		}
	}
}
