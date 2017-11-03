package pers.wxp.type;

import org.junit.Test;

/**
 * @author wxp
 * @date 2017��8��10�� ����4:32:19
 * @Description: TODO(����Long��������ط�������)
 */
public class LongDemo {

	/** 
	* @Description: TODO(�����ַ�ת���ɳ��������ʱ����λ����0�ǲ�����ת��) 
	* @param:     
	* @return void     
	*/
	@Test
	public void LongValueOf() {
		String str = "C89ED7DE";
		System.out.println(str.toLowerCase());
		//��0����
		String str1 = "00000000" + "C89ED7DE";
		//�÷������Խ�����������һ�����ַ�һ���ǻ���
		Long len = Long.valueOf(str, 16);
		Long len1 = Long.valueOf(str1, 16);
		System.out.println(len);		
		System.out.println(len1);
		
		String strhex = Long.toHexString(len);
		System.out.println(strhex);
	}
}
