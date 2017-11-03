package pers.wxp.type.string;

public class StringConvertTest {

	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return "0x" + str;// 0x��ʾʮ�����
	}

	// ת��ʮ����Ʊ���Ϊ�ַ�
	public static String toStringHex(String s) {
		if ("0x".equals(s.substring(0, 2))) {
			s = s.substring(2);
		}
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			s = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	public static void printHexString(byte[] b) {
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			System.out.print(hex.toUpperCase());
		}
	}

	public static void main(String[] args) throws Exception {
		String str = "wxpwxp";
		String str1 = "123";
		printHexString(str.getBytes());
		String hexString = "777870777870";
		String tset = toStringHex(hexString);
		System.out.println(tset);
		//��.����ת�����ַ���
		int a = 10;
		String num1 = Integer.toString(a);
		//��.ת����Int��
		Integer num = Integer.parseInt(str1);
	}

}
