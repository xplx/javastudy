package pers.wxp.type;

import org.junit.Test;

/**
 * @author wxp
 * @date 2017年8月10日 下午4:32:19
 * @Description: TODO(测试Long引用类相关方法操作)
 */
public class LongDemo {

	/** 
	* @Description: TODO(测试字符串转换成长整形数据时，高位数是0是不进行转换) 
	* @param:     
	* @return void     
	*/
	@Test
	public void LongValueOf() {
		String str = "C89ED7DE";
		System.out.println(str.toLowerCase());
		//补0测试
		String str1 = "00000000" + "C89ED7DE";
		//该方法可以接收两个参数一个是字符串，一个是基数。
		Long len = Long.valueOf(str, 16);
		Long len1 = Long.valueOf(str1, 16);
		System.out.println(len);		
		System.out.println(len1);
		
		String strhex = Long.toHexString(len);
		System.out.println(strhex);
	}
}
