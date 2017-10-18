package pers.wxp.gather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * @author wxp
 * @date 2017年10月13日 上午9:05:12
 * @Description: TODO(测试map缓存时，顺序查询某一个数，运用顺序分配IP地址)
 * @problem:(ListCache是怎么保存多组数据？多次New会不会被系统回收？不同对象查询时，还能查询到？)
 * @answer:(个人理解：new ListCache时，将对象保存在map中，下次查询时将查询map中对象查询到数据。)
 */
public class MapSaveList {
	// map中的值时ListCache。
	private static HashMap<String, ListCache> map = new HashMap<String, ListCache>();
	String[] aStringKey = { "11", "11", "22", "33", "33" };
	String[] aStringValue = { "1111", "1122", "2222", "3333", "3344" };

	@Test
	public void TestMapSaveList() {
		String key = "";
		List<Cache> list = new ArrayList<Cache>();
		for (int i = 0; i < aStringKey.length; i++) {
			String getKey = aStringKey[i];
			String getValue = aStringValue[i];
			Cache cache = new Cache(getKey, getValue);
			// 如果上次Key值和这次相等，加入list中
			if (key.equals(getKey)) {
				list.add(cache);
			} else {
				if (list.size() != 0) {
					map.put(key, new ListCache(list));
				}
				key = getKey;
				list = new ArrayList<Cache>();
				list.add(cache);
			}

		}
		if (list.size() != 0) {
			map.put(key, new ListCache(list));
		}
		for (int i = 0; i < aStringKey.length; i++) {
			// 获取key对应的map值。
			ListCache getName = map.get(aStringKey[i]);
			System.out.println(getName);
			// 获取缓存对象Cash
			Cache value = getName.getCache();
			System.out.println(value);
		}
	}
}

class ListCache {

	private int index;
	private List<Cache> list = new ArrayList<Cache>();

	// 构造方法作用就是对类进行初始化。
	public ListCache(List<Cache> listCache) {
		this.index = 0;
		this.list = listCache;
		System.out.println("list_size=" + list.size());
	}

	/**
	 * @Description: TODO(synchronized同一时刻只有一个对象运行该段代码)
	 * @param: @return
	 * @return Cache
	 */
	public synchronized Cache getCache() {

		System.out.println("list.index=" + index);
		if (index == list.size()) {
			index = 0;
		}

		Cache cache = list.get(index);
		System.out.println("list.cache=" + cache);
		index++;
		return cache;
	}

	@Override
	public String toString() {

		return "ListCache :" + list;
	}
}
