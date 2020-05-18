package pers.wxp.xml;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESCBCUtil implements Validation{

	public byte[] key = hex2Bytes("1122334455667788"); // 密匙
	public byte[] iv = hex2Bytes("0000000000000000"); // 初始向量iv

	/**
	 * DES-CBC加密函数
	 * 
	 * @param data
	 *            加密数据
	 * @param key
	 *            密钥
	 * @return 返回加密后的数据
	 */
	public byte[] CBCEncrypt(byte[] data) {

		try {
			// 从原始密钥数据创建DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(key);

			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			// 一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(dks);

			// Cipher对象实际完成加密操作
			// Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			// 若采用NoPadding模式，data长度必须是8的倍数
			Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");

			// 用密匙初始化Cipher对象
			IvParameterSpec param = new IvParameterSpec(iv);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, param);

			// 执行加密操作
			byte encryptedData[] = cipher.doFinal(data);

			return encryptedData;
		} catch (Exception e) {
			System.err.println("DES算法，加密数据出错!");
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * DES-CBC解密函数
	 * 
	 * @param data
	 *            解密数据
	 * @param key
	 *            密钥
	 * @return 返回解密后的数据
	 */
	public byte[] CBCDecrypt(byte[] data) {
		try {
			// 从原始密匙数据创建一个DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(key);

			// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
			// 一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(dks);

			// using DES in CBC mode
			// Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			// 若采用NoPadding模式，data长度必须是8的倍数
			Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");

			// 用密匙初始化Cipher对象
			IvParameterSpec param = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, param);

			// 正式执行解密操作
			byte decryptedData[] = cipher.doFinal(data);

			return decryptedData;
		} catch (Exception e) {
			System.err.println("DES算法，解密出错。");
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * hex转byte
	 * 
	 * @param hex
	 * @return
	 */
	public byte[] hex2Bytes(String hex) {
		if (hex == null || hex.length() % 2 > 0) {
			return null;
		}
		int len = hex.length() / 2;
		byte[] ret = new byte[len];
		int k = 0;
		for (int i = 0; i < len; i++) {
			int c = hex.charAt(k++);
			if (c >= '0' && c <= '9')
				c = c - '0';
			else if (c >= 'a' && c <= 'f')
				c = c - 'a' + 10;
			else if (c >= 'A' && c <= 'F')
				c = c - 'A' + 10;
			else {
				return null;
			}
			ret[i] = (byte) (c << 4);
			c = hex.charAt(k++);
			if (c >= '0' && c <= '9')
				c = c - '0';
			else if (c >= 'a' && c <= 'f')
				c = c - 'a' + 10;
			else if (c >= 'A' && c <= 'F')
				c = c - 'A' + 10;
			else {
				return null;
			}
			ret[i] += (byte) c;
		}
		return ret;
	}

	/**
	 * byte转hex
	 * 
	 * @param hex
	 * @return
	 */
	public String bytes2Hex(byte[] src) {
		char[] res = new char[src.length * 2];
		final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		for (int i = 0, j = 0; i < src.length; i++) {
			res[j++] = hexDigits[src[i] >>> 4 & 0x0f];
			res[j++] = hexDigits[src[i] & 0x0f];
		}

		return new String(res);
	}

	public String encrypt(String data) {
		byte[] b; 
		if (data.length() % 8 == 0) {
			b=new byte[data.length()]; 
		}else{
			b=new byte[data.length()/8*8+8]; 
		}
		for (int i = 0; i < data.length(); i++) {
			b[i]=data.getBytes()[i];
		}
		
		byte[] cbcEncrypt = CBCEncrypt(b);
		return bytes2Hex(cbcEncrypt).substring(bytes2Hex(cbcEncrypt).length()-16);
	}

	public String decrypt(String data) {
		return "";
	}

}
