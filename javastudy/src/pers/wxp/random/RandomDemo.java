package pers.wxp.random;

import java.util.Random;

import org.junit.Test;

public class RandomDemo {
	
	
	
	/** 
	* @Description: TODO(测试怎么获取指定的字符串的随机数)    
	*/
	@Test
	public void createRandom() {

		String str = "123456789";

		char[] rands = new char[4];

		Random random = new Random();

		for (int i = 0; i < 4; i++) {
			int rand = random.nextInt(9);
			rands[i] = str.charAt(rand);
		}
	}
}
