package pers.wxp.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class Mddd5 {
	/**
	 * ����MD5����
	 * 
	 * @param String
	 *            ԭʼ��SPKEY
	 * @return byte[] ָ�����ܷ�ʽΪmd5���byte[]
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
	 * �õ�3-DES����Կ�� ���ݸ�����Ҫ������Կ��Ϊ24���ֽڣ�md5���ܳ�������16���ֽڣ���˺��油8���ֽڵ�0
	 * 
	 * @param String
	 *            ԭʼ��SPKEY
	 * @return byte[] ָ�����ܷ�ʽΪmd5���byte[]
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
	 * 3-DES����
	 * 
	 * @param byte[]
	 *            src Ҫ����3-DES���ܵ�byte[]
	 * @param byte[]
	 *            enKey 3-DES������Կ
	 * @return byte[] 3-DES���ܺ��byte[]
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
     * ����MD5�򵥷��� 
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
