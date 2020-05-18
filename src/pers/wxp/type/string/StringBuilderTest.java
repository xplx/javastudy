package pers.wxp.type.string;

import org.junit.Test;

public class StringBuilderTest {

	@Test
	public void StringTest() {
		StringBuilder sb = new StringBuilder();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 1000; i++) {
			stringBuffer.append(i);

		}
		String string = "0123456789";
		System.out.println(string.substring(2, 4));
	}
	
}
