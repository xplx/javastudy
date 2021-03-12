package pers.wxp.type;

import java.util.Random;

import org.junit.Test;

public class RandomDemo {
	
	
	
	/** 
	* @Description: TODO(������ô��ȡָ�����ַ�������)    
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
