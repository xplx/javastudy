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
		System.out.println(stringBuffer);
	}
}
