package pers.wxp.type.string;

import org.junit.Test;

/**
 * @author wuxiaopeng
 * @date 2017年6月13日 下午2:32:31
 * @Description: TODO(测试String) string不能被继承
 * 
 */
public class StringTest {

	/**
	 * @date 2017年6月13日 下午2:32:59
	 * @Description: TODO(“String”其中String就是一个对象)
	 */
	@Test
	public void StringAnonymity() {
		String string1 = null;
		String string2 = "hello";
		System.out.println("hello".equals(string1));
		System.out.println(string1.equals(string2));
	}

	@Test
	public void String1() {
		String str1 = "hello";
		String str2 = "hello";
		String str3 = "hello";// 指向同一个内存
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str2 == str3);

		String str4 = new String("hello");// 开辟不同内存
		String str5 = new String("hello");
		String str6 = new String("hello");
		System.out.println(str4 == str5);
		System.out.println(str4 == str6);
		System.out.println(str5 == str6);

		String str7 = new String("hello").intern();// 转为池内
		System.out.println(str7 == str3);

	}

	@Test
	public void String2() {
		String str1 = "hello word !!";
		System.out.println(str1);
		String str2[] = str1.split(" ");
		for (int i = 0; i < str2.length; i++) {
			System.out.println(str2[i]);
		}
		String str3 = "he";
		str3.concat(str1);
		System.out.println(str3);
	}

	/**
	 * @date 2017年6月15日 下午4:51:14
	 * @Description: TODO(替换指定的字符)
	 */
	@Test
	public void String3() {

		String str1 = "a1aaaabbbbbbb2ccffdd36";
		String regex = "[a-zA-Z]+";
		System.out.println(str1.replaceAll(regex, ""));// 将regex子母替换为指定的子母
		System.out.println(str1.replaceFirst(regex, ""));// 替换首字母
	}

	/**
	 * @date 2017年6月15日 下午4:50:47
	 * @Description: TODO(按指定的格式分割字符)
	 */
	@Test
	public void String4() {

		String str1 = "a1aaa4abbb4bbbb2ccffdd36";
		String regex = "\\d";// 任意数字
		String string[] = str1.split(regex);
		for (int i = 0; i < string.length; i++) {
			System.out.println(string[i]);
		}
	}

	/**
	 * @date 2017年6月15日 下午4:53:37
	 * @Description: TODO(按照指定数据验证)
	 */
	@Test
	public void String5() {
		String str1 = "123";
		String regex = "\\d+";// 任意数字
		System.out.println(str1.matches(regex));
	}

	/**
	 * @Description: TODO(测试位置索引)
	 * @param:
	 * @return void
	 */
	@Test
	public void String6() {
		String nodeName = "www.salvador.com#BusSystem#BusGateway.12345";
		int lastIndex = nodeName.lastIndexOf("#");
		// 索引从指定位置开始字符所在位置
		int index = nodeName.indexOf(".");
		System.out.println(index);
		String name = "User's name";
		name = name.replace("'s", "");
	}

}
