package pers.wxp.xml;

public class ValidationHelper {

	static Validation validation;

	public static boolean validation(int n, String data1, String data2,
			String data3) {
		boolean boo = false;
		switch (n) {
		case 0:
			boo=true;
			break;
		case 1:
			validation = new DESCBCUtil();
			String str = validation.encrypt(data1 + data2);
			if (str.equals(data3)) {
				boo = true;
			} else {
				boo = false;
			}
			break;
		case 2:
			boo=true;
			break;
		default:
			break;
		}
		return boo;
	}

	public static String getCode(int n, String data1, String data2) {
		String str = "";
		switch (n) {
		case 1:
			Validation  v = new DESCBCUtil();
			str = v.encrypt(data1+data2);
			break;
		default:
			break;
		}
		return str;
	}

}
