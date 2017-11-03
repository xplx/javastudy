package pers.wxp.type.string;

import org.junit.Test;

/**
 * @author 作者 E-mail:
 * @date 创建时间：2017年6月13日 下午5:15:17
 * @Description: TODO(测试system类)
 * @version 1.0
 * @parameter
 */
public class SystemDemo {

	@Test
	public void systemDemo() {
		Long beginTime = System.currentTimeMillis();
		String string = " ";
		for (int i = 0; i < 3000; i++) {
			//System.out.println("123");
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("运行" + (endTime - beginTime) + "ms");
	}
}
