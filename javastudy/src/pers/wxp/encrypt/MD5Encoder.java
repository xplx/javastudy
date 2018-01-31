package pers.wxp.encrypt;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * MD5加密工具实现类(不支持逆转算法)
 */
public class MD5Encoder {

	public String decrypt(String password, String key) {
		// 不支持该方法抛出UnsupportedOperationException异常
		throw new UnsupportedOperationException("Not supported the mehtod");
	}

	public String encrypt(String password) {
		// 使用SPRING SECURITY3里的MD5实现类
		return new Md5PasswordEncoder().encodePassword(password, null);
	}

	public String encrypt(String password, String salt) {
		// 使用SPRING SECURITY3里的MD5实现类
		return new Md5PasswordEncoder().encodePassword(password, salt);
	}

	public static void main(String[] args) {
		System.out.println(new MD5Encoder().encrypt("111111", "b97881241a2e445da673daf51ca244b9"));
		System.out.println(new MD5Encoder().encrypt("111111", "b97881241a2e445da673daf51ca244b9"));
		System.out.println(new MD5Encoder().encrypt("111111", "b97881241a2e445da673daf51ca244b7"));
		System.out.println(new MD5Encoder().encrypt("111111", "b97881241a2e445da673daf51ca244b8"));
	}
}
