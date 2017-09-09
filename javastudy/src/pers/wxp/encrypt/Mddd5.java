package pers.wxp.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class Mddd5 {
	/**
	 * 进行MD5加密
	 * 
	 * @param String
	 *            原始的SPKEY
	 * @return byte[] 指定加密方式为md5后的byte[]
	 */
	private static byte[] md5(String strSrc) {
		byte[] returnByte = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			returnByte = md5.digest(strSrc.getBytes("GBK"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnByte;
	}

	/**
	 * 得到3-DES的密钥匙 根据根据需要，如密钥匙为24个字节，md5加密出来的是16个字节，因此后面补8个字节的0
	 * 
	 * @param String
	 *            原始的SPKEY
	 * @return byte[] 指定加密方式为md5后的byte[]
	 */
	private static byte[] getEnKey(String spKey) {
		byte[] desKey = null;
		try {
			byte[] desKey1 = md5(spKey);
			desKey = new byte[24];
			int i = 0;
			while (i < desKey1.length && i < 24) {
				desKey[i] = desKey1[i];
				i++;
			}
			if (i < 24) {
				desKey[i] = 0;
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desKey;
	}

	/**
	 * 3-DES加密
	 * 
	 * @param byte[]
	 *            src 要进行3-DES加密的byte[]
	 * @param byte[]
	 *            enKey 3-DES加密密钥
	 * @return byte[] 3-DES加密后的byte[]
	 */
	public static byte[] Encrypt(byte[] src, byte[] enKey) {
		byte[] encryptedData = null;
		try {
			DESedeKeySpec dks = new DESedeKeySpec(enKey);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
			SecretKey key = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encryptedData = cipher.doFinal(src);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedData;
	}

	/** 
     * 生成MD5简单方法 
     * @param str 
     * @return 
     */  
    public static StringBuilder getMD5(String str){  
        byte [] buf=str.getBytes();  
        MessageDigest md5;  
        StringBuilder sb=new StringBuilder();  
        try {  
            md5 = MessageDigest.getInstance("MD5");  
            md5.update(buf);  
            byte [] tmp=md5.digest();  
            for (byte b:tmp) {  
                sb.append(Integer.toHexString(b&0xff));  
            }  
        } catch (NoSuchAlgorithmException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return sb;  
    }  
	public static void main(String[] args) {
		System.out.println("md5" + md5("12345"));//15db9742
		md5("12345");
		System.out.println("3-DES" + getEnKey("12345"));
		getEnKey("12345");
		System.out.println(getMD5("123456"));
		getMD5("123456");
		System.out.println(getMD5("123456"));
		getMD5("123456");
		System.out.println(getMD5("123456"));
		getMD5("123456");

	}
}
