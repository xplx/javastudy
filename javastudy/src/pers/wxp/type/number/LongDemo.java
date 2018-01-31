package pers.wxp.type.number;

import org.junit.Test;

/** 
* @author wxp  
* @date 2018年1月29日 下午1:35:46 
* @Description: TODO(这里用一句话描述这个类的作用) 
*/
public class LongDemo {
	@Test
	public void LongValueOf() {
		String str = "C89ED7DE";
		System.out.println(str.toLowerCase());
		String str1 = "00000000" + "C89ED7DE";
		Long len = Long.valueOf(str, 16);
		Long len1 = Long.valueOf(str1, 16);
		System.out.println(len);		
		System.out.println(len1);		
		String strhex = Long.toHexString(len);
		System.out.println(strhex);
	}
	
	@Test
	public void floatCompare(){
		//3.4是双精度数据（double）
		float f1 = 3;
	}
}
