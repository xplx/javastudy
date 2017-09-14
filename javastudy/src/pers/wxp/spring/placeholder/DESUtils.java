package pers.wxp.spring.placeholder;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;



/** 
* @author wxp  
* @date 2017年9月14日 下午1:47:44 
* @Description: TODO(DES可以加密解密信息) 
*/
public class DESUtils {
	//指定加密解密密钥
	private static Key key;
	private static String KEY_STR = "myKey";
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			System.out.println("key:"+key);
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对str进行DES加密
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncryptString(String str) {
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64en.encode(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对str进行DES解密
	 * 
	 * @param str
	 * @return
	 */
	public static String getDecryptString(String str) {
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			byte[] strBytes = base64De.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) throws Exception {
		//通过给函数入参进行加密
		if (args == null || args.length < 1) {
			System.out.println("请输入要加密的字符，用空格分隔.");
		} else {
			for (String arg : args) {
				System.out.println(arg + ":" + getEncryptString(arg));
			}
		}
		System.out.println(getEncryptString("tcps"));
		System.out.println(getDecryptString("S3co/ziET/Q="));
		System.out.println(getDecryptString("WnplV/ietfQ="));
		System.out.println(getDecryptString("gJQ9O+q34qk="));
	}
}