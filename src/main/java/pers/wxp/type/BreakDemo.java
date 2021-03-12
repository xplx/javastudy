package pers.wxp.type;

import org.junit.Test;

/**
 * @author wxp
 * @date 2017年10月17日 下午5:31:10
 * @Description: TODO(关于java跳转问题)
 */
public class BreakDemo {

	/**
	 * @Description: TODO(break:跳出当前的多重嵌套循环，continue:跳出当前循环)
	 * 
	 * @param:
	 * @return void
	 */
	@Test
	public void BreakDemoTest() {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 9 } };

		boolean found = false;// 作为跳出多重循环标记

		for (int i = 0; i < arr.length && !found; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				if (arr[i][j] == 5) {

					found = true;

					// break;
					continue;

				}

			}

		}
	}
}
