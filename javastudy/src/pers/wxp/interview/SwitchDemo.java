package pers.wxp.interview;

import org.junit.Test;

/** 
* @author wxp  
* @date 2018年1月30日 下午2:47:08 
* @Description: TODO(switch语句能否作用在byte上，能否作用在long上，能否作用在String上? (可以)) 
*/
public class SwitchDemo {
	@Test
	public void switchTest(){
		//String key = "test";
		int key =0;
		switch (key) {
		case 0:
			System.out.println("test");
			break;
			
		default:
			break;
		}
	}
}
