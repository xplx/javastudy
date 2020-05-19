package pers.wxp.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author wxp
 * @date 2018年1月18日 下午4:16:39
 * @Description: TODO(Base64一开始是为了解决邮件中不能传文件和图片问题而使用的，将无法阅读的二进制码转化成字符形式，字符为（A-Za-z0-9+/）。)
 */
public class Base64Encoder {
	//加密
	public static String getBASE64(String s) {
		if (s == null){
			return null;
		}
		return (new BASE64Encoder()).encode(s.getBytes());
	}
	public static String getFromBASE64(String s) {
		if (s == null){
			return null;
		}
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
		//加密
		System.out.println(a);
		//解密
		System.out.println(aTOm(a));
	}
}
