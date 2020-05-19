package pers.wxp.gather;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author wxp
 * @date 2017年10月17日 下午3:08:38
 * @Description: TODO(遍历Map对象的4种方法 )
 */
public class MapTestLoop {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public void initMapTestLoop() {
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 5);
		map.put(6, 6);
		map.put(7, 7);
	}

	/**
	 * @Description: TODO(这是最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用。)
	 * @param:
	 * @return void
	 */
	@Test
	public void TestLoopTestOne() {
		initMapTestLoop();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

		}

	}
}
