/** 
 * @file Base64Encoder.java 
 * @date 2016��8��5�� 
 * @version 3.4.1 
 * 
 * Copyright (c) 2013 Sihua Tech, Inc. All Rights Reserved. 
 */
package pers.wxp.encrypt;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

/**
 * 
 * 
 * @author chengjian.he
 * @version 3.4, 2016��8��5�� ����10:44:22
 * @since Yeexun 3.4
 */
public class Base64Encoder {
	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new BASE64Encoder()).encode(s.getBytes());
	}

	// �� BASE64 ������ַ� s ���н��� ����
	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	public static String mTOa(Object ming) {
		return Base64Encoder.getBASE64(Base64Encoder.getBASE64(Base64Encoder.getBASE64((String) ming)));
	}

	public static String aTOm(String an) {
		return Base64Encoder.getFromBASE64(Base64Encoder.getFromBASE64(Base64Encoder.getFromBASE64(an)));
	}

	public static void main(String[] args) {
		String a = mTOa("100000.89".toString());
		System.out.println(a);// ����
		System.out.println(aTOm(a));// ����
	}
}
