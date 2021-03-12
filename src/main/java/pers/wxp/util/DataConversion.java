package pers.wxp.util;

//import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

/**
 * Author: Wu Hao Date:2013-6-27 Purpose:for Developerment in Linux.
 */
public class DataConversion {

	public static String amountFormat = "1";

	/**
	 * append string in str
	 * 
	 * @param str
	 *            Format:must HEX Code, and string is 2 multiple.
	 * @return
	 */
	public static String Supply00(String sOldStr, int SupplyWay, String SupplyChar, int SupplyNum) {
		int i;
		String sTmp = "";

		for (i = sOldStr.length(); i < SupplyNum; i++) {
			sTmp = sTmp + SupplyChar;
		}
		switch (SupplyWay) {
		case 0:
			sTmp = sTmp + sOldStr;
			break;
		case 1:
			sTmp = sOldStr + sTmp;
			break;
		default:
			sTmp = sOldStr;
			break;
		}
		return sTmp;
	}

	/**
	 * Wipe off space for string
	 * 
	 * @param str
	 * @return str
	 */
	public static String WipeOffSpace(String str) {
		String retStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (!str.substring(i, i + 1).equals(" ")) {
				retStr = retStr + str.substring(i, i + 1);
			}
		}
		return retStr;
	}

	/**
	 * String conversion to hex ASCII code. for example: input:
	 * abcdefghi1(字符串转换成ASCII字符串) output:61626364656667686931
	 */
	public static String strToHexAsciiStr(String str) {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
		}
		return sb.toString();
	}

	@Test
	public void testMothed() {
		System.out.println(DataConversion.strToHexAsciiStr("abcdefghi1"));
		System.out.println(DataConversion.WipeOffSpace("abcdefghi1"));
	}

	/**
	 * hex ASCII code conversion to String. for example: input:(ascii字符串变成字符串)
	 * 61626364656667686931 output:abcdefghi1
	 */
	public static String asciiStrToStr(String hexStr) {
		hexStr = WipeOffSpace(hexStr);
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}

	/**
	 * byte array conversion to hex string,input byte used base complement. for
	 * example: input: -85 -51 -17 output:ABCDEF
	 */
	public static String bytesToHexStr(byte[] b) {
		String hs = "";
		String stmp = "";
		if (b == null) {
			return "";
		}
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			// if (n<b.length-1) hs=hs+":";
		}
		return hs.toUpperCase();
	}

	/**
	 * byte conversion to hex string,input byte used base complement. for
	 * example: input: -85 output:AB
	 */
	public static String byteToHexStr(byte b) {
		String stmp = "";

		stmp = (Integer.toHexString(b & 0XFF));
		if (stmp.length() == 1)
			stmp = "0" + stmp;

		return stmp.toUpperCase();
	}

	/**
	 * byte conversion to Integer string,input byte used base complement. for
	 * example: input: -85 output:AB
	 */
	public static String byteToIntStr(byte b) {
		String stmp = "";

		stmp = (Integer.toHexString(b & 0XFF));
		if (stmp.length() == 1)
			stmp = "0" + stmp;

		return Integer.valueOf(stmp, 16).toString();
	}

	/**
	 * hex char conversion to byte,output byte used base complement. for
	 * example: input: src0=a src1=b output:-85
	 */
	private static byte uniteBytes(String src0, String src1) {
		byte b0 = Byte.decode("0x" + src0).byteValue();
		b0 = (byte) (b0 << 4);
		byte b1 = Byte.decode("0x" + src1).byteValue();
		byte ret = (byte) (b0 | b1);
		return ret;
	}

	/**
	 * hex string conversion to byte array,output byte used base complement. for
	 * example: input: abcdef output:-85 -51 -17
	 */
	public static byte[] hexStrToBytes(String src) {
		src = WipeOffSpace(src);
		if (!TypeJudge.isHexString(src)) {
			return null;
		}

		int m = 0, n = 0;
		int l = src.length() / 2;
		byte[] ret = new byte[l];
		for (int i = 0; i < l; i++) {
			m = i * 2 + 1;
			n = m + 1;
			ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));
		}
		return ret;
	}

	/*
	 * private static int hexCharToVal(char ch) { if (ch >= 'a' && ch <= 'f') {
	 * return ch - 'a' + 10; } else if (ch >= 'A' && ch <= 'F') { return ch -
	 * 'A' + 10; } else if (ch >= '0' && ch <= '9') { return ch - '0'; } else {
	 * return 0; } }
	 * 
	 * public static byte[] HexStringToBytes(String hexStr) { int bytelen =
	 * (hexStr.length() + 1) / 2; byte[] buf = new byte[bytelen]; for (int i =
	 * 0; i < bytelen; i++) { int high = hexCharToVal(hexStr.charAt(i * 2)); int
	 * low = (i == bytelen - 1 && hexStr.length() + 1 == bytelen * 2) ? 0 :
	 * hexCharToVal(hexStr.charAt(i * 2 + 1)); buf[i] = (byte) ((high << 4) |
	 * (low & 0x0f)); } return buf;//new HexBytes(hexString).getBytes(); }
	 */

	/**
	 * for example: input: abcd1234áéíóú????a?e?i?u?ot output:true/false
	 */
	public static Boolean isSingleByteChar(String strText) {
		char c;
		// String strRet = "";
		int intAsc;
		// String strHex;
		for (int i = 0; i < strText.length(); i++) {
			c = strText.charAt(i);
			intAsc = (int) c;
			// strHex = Integer.toHexString(intAsc);
			if (intAsc > 255) {
				return false;
			}
		}
		return true;
	}

	/**
	 * string conversion to unicode string. output format:1Bytes for example:
	 * input: abcd1234áéíóú????a?e?i?u?ot
	 * output:6162636431323334c1e9edf3faa13fbff161f165f169f175f16ffe
	 */
	public static String stringToUnicodeForSingleByte(String strText) {
		char c;
		String strRet = "";
		int intAsc;
		String strHex;
		for (int i = 0; i < strText.length(); i++) {
			c = strText.charAt(i);
			intAsc = (int) c;
			strHex = Integer.toHexString(intAsc);
			if (intAsc > 255) {
				return "";
			} else {
				strRet += "" + strHex;
			}
		}
		return strRet;
	}

	/**
	 * unicode string conversion to string. input format:1Bytes for example:
	 * input: 6162636431323334c1e9edf3faa13fbff161f165f169f175f16ffe
	 * output:abcd1234áéíóú????a?e?i?u?ot
	 */
	public static String unicodeToStringForSingleByte(String hex) {
		hex = WipeOffSpace(hex);
		int t = hex.length() / 2;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < t; i++) {
			String s = hex.substring(i * 2, (i + 1) * 2);
			// Get single byte
			String s1 = s.substring(0, 2);
			// hex string to int
			int n = Integer.valueOf(s1, 16);
			// from int to char
			char[] chars = Character.toChars(n);
			str.append(new String(chars));
		}
		return str.toString();
	}

	/**
	 * string conversion to unicode string. Output format:2Bytes for example:
	 * input: abcd中国1234 output:00610062006300644e2d56fd0031003200330034
	 */
	public static String stringToUnicodeForDoubleByte(String strText) {
		char c;
		String strRet = "";
		int intAsc;
		String strHex;
		for (int i = 0; i < strText.length(); i++) {
			c = strText.charAt(i);
			intAsc = (int) c;
			strHex = Integer.toHexString(intAsc);
			if (intAsc > 255) {
				strRet += "" + strHex;
			} else {
				strRet += "00" + strHex;
			}
		}
		return strRet;
	}

	/**
	 * unicode string conversion to string. Input format:2Bytes for example:
	 * input: 00610062006300644e2d56fd0031003200330034 output:abcd中国1234
	 */
	public static String unicodeToStringForDoubleByte(String hex) {
		hex = WipeOffSpace(hex);
		int t = hex.length() / 4;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < t; i++) {
			String s = hex.substring(i * 4, (i + 1) * 4);
			// High byte add 00
			String s1 = s.substring(0, 2) + "00";
			// get Low byte
			String s2 = s.substring(2);
			// hex string to int
			int n = Integer.valueOf(s1, 16) + Integer.valueOf(s2, 16);
			// from int to char
			char[] chars = Character.toChars(n);
			str.append(new String(chars));
		}
		return str.toString();
	}

	/**
	 * hex string conversion to byte array,output byte used base complement. for
	 * example: input: abcdef1 output:61,62,63,64,65,66,31
	 */
	public static byte[] StrToAsciiBytes(String src) {
		src = WipeOffSpace(src);
		int l = src.length();
		char[] tmpChar = new char[l];
		byte[] ret = new byte[l];
		tmpChar = src.toCharArray();
		for (int i = 0; i < l; i++) {
			ret[i] = (byte) tmpChar[i];
		}
		return ret;
	}

	/**
	 * Calculate CRC Value for String
	 * 
	 * @param str
	 *            Format:must HEX Code, and string is 2 multiple.
	 * @return
	 */
	public static String getCRC(String str) {
		int iVal = 0;
		if (!TypeJudge.isHexString(str) || (str.length() % 2 != 0))
			return "";

		for (int i = 0; i < str.length() / 2; i++) {
			iVal = iVal ^ Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
		}
		return Supply00(Integer.toHexString(iVal).toUpperCase(), 0, "0", 2);
	}

	private static int[] CRCtable = { 0X0000, 0X1021, 0X2042, 0X3063, 0X4084, 0X50A5, 0X60C6, 0X70E7, 0X8108, 0X9129, 0XA14A, 0XB16B, 0XC18C, 0XD1AD, 0XE1CE,
			0XF1EF, 0X1231, 0X0210, 0X3273, 0X2252, 0X52B5, 0X4294, 0X72F7, 0X62D6, 0X9339, 0X8318, 0XB37B, 0XA35A, 0XD3BD, 0XC39C, 0XF3FF, 0XE3DE, 0X2462,
			0X3443, 0X0420, 0X1401, 0X64E6, 0X74C7, 0X44A4, 0X5485, 0XA56A, 0XB54B, 0X8528, 0X9509, 0XE5EE, 0XF5CF, 0XC5AC, 0XD58D, 0X3653, 0X2672, 0X1611,
			0X0630, 0X76D7, 0X66F6, 0X5695, 0X46B4, 0XB75B, 0XA77A, 0X9719, 0X8738, 0XF7DF, 0XE7FE, 0XD79D, 0XC7BC, 0X48C4, 0X58E5, 0X6886, 0X78A7, 0X0840,
			0X1861, 0X2802, 0X3823, 0XC9CC, 0XD9ED, 0XE98E, 0XF9AF, 0X8948, 0X9969, 0XA90A, 0XB92B, 0X5AF5, 0X4AD4, 0X7AB7, 0X6A96, 0X1A71, 0X0A50, 0X3A33,
			0X2A12, 0XDBFD, 0XCBDC, 0XFBBF, 0XEB9E, 0X9B79, 0X8B58, 0XBB3B, 0XAB1A, 0X6CA6, 0X7C87, 0X4CE4, 0X5CC5, 0X2C22, 0X3C03, 0X0C60, 0X1C41, 0XEDAE,
			0XFD8F, 0XCDEC, 0XDDCD, 0XAD2A, 0XBD0B, 0X8D68, 0X9D49, 0X7E97, 0X6EB6, 0X5ED5, 0X4EF4, 0X3E13, 0X2E32, 0X1E51, 0X0E70, 0XFF9F, 0XEFBE, 0XDFDD,
			0XCFFC, 0XBF1B, 0XAF3A, 0X9F59, 0X8F78, 0X9188, 0X81A9, 0XB1CA, 0XA1EB, 0XD10C, 0XC12D, 0XF14E, 0XE16F, 0X1080, 0X00A1, 0X30C2, 0X20E3, 0X5004,
			0X4025, 0X7046, 0X6067, 0X83B9, 0X9398, 0XA3FB, 0XB3DA, 0XC33D, 0XD31C, 0XE37F, 0XF35E, 0X02B1, 0X1290, 0X22F3, 0X32D2, 0X4235, 0X5214, 0X6277,
			0X7256, 0XB5EA, 0XA5CB, 0X95A8, 0X8589, 0XF56E, 0XE54F, 0XD52C, 0XC50D, 0X34E2, 0X24C3, 0X14A0, 0X0481, 0X7466, 0X6447, 0X5424, 0X4405, 0XA7DB,
			0XB7FA, 0X8799, 0X97B8, 0XE75F, 0XF77E, 0XC71D, 0XD73C, 0X26D3, 0X36F2, 0X0691, 0X16B0, 0X6657, 0X7676, 0X4615, 0X5634, 0XD94C, 0XC96D, 0XF90E,
			0XE92F, 0X99C8, 0X89E9, 0XB98A, 0XA9AB, 0X5844, 0X4865, 0X7806, 0X6827, 0X18C0, 0X08E1, 0X3882, 0X28A3, 0XCB7D, 0XDB5C, 0XEB3F, 0XFB1E, 0X8BF9,
			0X9BD8, 0XABBB, 0XBB9A, 0X4A75, 0X5A54, 0X6A37, 0X7A16, 0X0AF1, 0X1AD0, 0X2AB3, 0X3A92, 0XFD2E, 0XED0F, 0XDD6C, 0XCD4D, 0XBDAA, 0XAD8B, 0X9DE8,
			0X8DC9, 0X7C26, 0X6C07, 0X5C64, 0X4C45, 0X3CA2, 0X2C83, 0X1CE0, 0X0CC1, 0XEF1F, 0XFF3E, 0XCF5D, 0XDF7C, 0XAF9B, 0XBFBA, 0X8FD9, 0X9FF8, 0X6E17,
			0X7E36, 0X4E55, 0X5E74, 0X2E93, 0X3EB2, 0X0ED1, 0X1EF0 };

	public static int UpdateCRC(int crc, final int c) {
		return (crc << 8) ^ CRCtable[((crc >> 8) ^ c) & 0xFF];
	}

	/**
	 * for gprs/3G communication
	 * 
	 * @param hexStr
	 *            hex parameter
	 * @return CRC
	 */
	public static int mkCrc(String hexStr) {
		int crc = 0;
		byte[] b = hexStrToBytes(hexStr);
		for (int i = 0; i < b.length; i++) {
			crc = UpdateCRC(crc, b[i]);
		}
		crc = crc & 0xFFFF;
		return crc;
	}

	/**
	 * @param null
	 * @return UTC (4 Bytes String)
	 */
	public static String getLocalUTC() {
		String sUTC = "";
		// SimpleDateFormat format = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long utc = new Date().getTime() / 1000;
		sUTC = Supply00(Long.toHexString(utc), 0, "0", 8);
		return sUTC;
	}

	/**
	 * @param null
	 * @return String YYYYMMDDhhmmss(7 Bytes String)
	 */
	public static String getNowDate() {
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss");
		return fm.format(new Date().getTime());
	}

	/**
	 * @param null
	 * @return Date (4 Bytes String)
	 */
	public static String UTCtoDate(String sUTC) {
		Date retDate = new Date(Long.valueOf(sUTC, 16) * 1000);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return format.format(retDate);
	}

	public static String utc2Local(String utcTime, String utcTimePatten, String localTimePatten) {
		SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
		utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date gpsUTCDate = null;
		try {
			gpsUTCDate = utcFormater.parse(utcTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten);
		localFormater.setTimeZone(TimeZone.getDefault());
		String localTime = localFormater.format(gpsUTCDate.getTime());
		return localTime;
	}

	/**
	 * 3Des function
	 * 
	 * @param args
	 *            ,sun company provide, at $JAVA_HOME/jre/lib/ have 4 jar file：
	 *            jce.jar,*security/US_export_policy.jar,
	 *            *security/local_policy.jar,*ext/sunjce_provider.jar
	 */
	private static final String Algorithm = "DESede"; // DES,DESede,Blowfish
														// //DESede/CBC/PKCS5Padding

	// @keybyte: encrypt key,length is 24Byte
	// @src: encrypt data
	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			// Create key
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// encrypt
			Cipher c1 = Cipher.getInstance("DESede/ECB/NoPadding");
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// keybyte: decrypt key,length is 24Byte
	// src: decrypt data
	public static byte[] decryptMode(byte[] keybyte, byte[] src) {
		try {
			// Create key
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// decrypt
			Cipher c1 = Cipher.getInstance("DESede/ECB/NoPadding");
			c1.init(Cipher.DECRYPT_MODE, deskey);
			// byte[] bRetBytes = c1.doFinal(src);
			// return bRetBytes;
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	/**
	 * 字符串转换到时间格式
	 * 
	 * @param dateStr
	 *            需要转换的字符串
	 * @param formatStr
	 *            需要格式的目标字符串 举例 yyyy-MM-dd
	 * @return Date 返回转换后的日期/null
	 */
	public static Date StringToDate(String dateStr, String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Date retDate = null;
		try {
			retDate = sdf.parse(dateStr);
		} catch (ParseException e) {
			retDate = null;
		}
		return retDate;
	}

	/**
	 * Date + days(+-)
	 * 
	 * @param inDate
	 *            需要转换的日期
	 * @param iDays
	 *            加减的天数
	 * @return Date 返回转换后的日期/null
	 */
	public static Date addDate(Date inDate, int iDays) {
		Date retDate = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			retDate = df.parse(df.format(inDate.getTime() - (long) (iDays * 24 * 60 * 60 * 1000)));
		} catch (ParseException e) {
			retDate = null;
		}
		return retDate;
	}

	/**
	 * Date + days(+-)
	 * 
	 * @param inDate
	 *            需要转换的日期
	 * @param iDays
	 *            加减的天数
	 * @return Date 返回转换后的日期/null
	 */
	public static long dateInterval(Date Date1, Date Date2) {
		long retDays = (Date1.getTime() - Date2.getTime()) / (24 * 60 * 60 * 1000);
		return retDays;
	}

	public static String StringFormat(String inputValue) {
		Double dTmp = 0.00;
		NumberFormat currencyFormat;
		if ("0".equals(amountFormat)) {
			currencyFormat = NumberFormat.getInstance(new Locale("zh", "CN"));
		} else {
			currencyFormat = NumberFormat.getNumberInstance();
		}

		try {
			dTmp = currencyFormat.parse(inputValue).doubleValue();
		} catch (ParseException e) {
			dTmp = 0.00;
			e.printStackTrace();
		}

		String resultValue;
		if ("0".equals(amountFormat)) {
			resultValue = String.format(new Locale("zh", "CN"), "%.2f", dTmp);
		} else {
			resultValue = String.format("%.2f", dTmp);
		}
		return resultValue;
	}

	public static Double StringToDouble(String inputValue) {
		Double dTmp = 0.00;
		NumberFormat currencyFormat;
		if ("0".equals(amountFormat)) {
			currencyFormat = NumberFormat.getInstance(new Locale("zh", "CN"));
		} else {
			currencyFormat = NumberFormat.getNumberInstance();
		}
		try {
			dTmp = currencyFormat.parse(inputValue).doubleValue();
		} catch (ParseException e) {
			dTmp = 0.00;
			e.printStackTrace();
		}
		return dTmp;
	}

	public static String DoubleToString(Double inputValue) {
		String sRet;
		NumberFormat currencyFormat;
		if ("0".equals(amountFormat)) {
			currencyFormat = NumberFormat.getInstance(new Locale("zh", "CN"));
		} else {
			currencyFormat = NumberFormat.getNumberInstance();
		}

		sRet = StringFormat(currencyFormat.format(inputValue));

		return sRet;
	}

	/**
	 * 小数计算 数值计算String（元）转换long(分)
	 * 
	 * @param inputValue
	 *            从数据库中取得（无国际化问题）
	 * @return
	 */
	public static long StringToLong(String inputValue) {
		BigDecimal bd = new BigDecimal(inputValue);
		return bd.multiply(new BigDecimal("100")).longValue();
	}

	// *********************************************
	// 字符串加解密
	// *********************************************
	static class EncipherConst {
		public final static String m_strKey1 = "zxcvbnm,./asdfg";
		public final static String m_strKeya = "cjk;";
		public final static String m_strKey2 = "hjkl;'qwertyuiop";
		public final static String m_strKeyb = "cai2";
		public final static String m_strKey3 = "[]\\1234567890-";
		public final static String m_strKeyc = "%^@#";
		public final static String m_strKey4 = "=` ZXCVBNM<>?:LKJ";
		public final static String m_strKeyd = "*(N";
		public final static String m_strKey5 = "HGFDSAQWERTYUI";
		public final static String m_strKeye = "%^HJ";
		public final static String m_strKey6 = "OP{}|+_)(*&^%$#@!~";
	}

	// 加密
	public static String EncodeStr(String strData) {
		/************
		 * 由于与sso的心跳用到发送时加密，从而会不一致，暂时启用****************** String strEncode = new
		 * String(""); int i; int n; char code; String des = new String();
		 * String strKey = new String(); if((strData == null) ||
		 * strData.length() == 0){ strEncode = ""; return strEncode; }
		 * 
		 * strData = stringToUnicodeForSingleByte(strData);
		 * 
		 * strKey = EncipherConst.m_strKey1 + EncipherConst.m_strKey2 +
		 * EncipherConst.m_strKey3 + EncipherConst.m_strKey4 +
		 * EncipherConst.m_strKey5 + EncipherConst.m_strKey6;
		 * while(strData.length() < 8) { strData = strData + (char)1; } des =
		 * ""; for(n = 0; n <= strData.length() - 1; n++){ while(true){ code =
		 * (char)Math.rint(Math.random() * 100); while((code > 0) && (((code ^
		 * strData.charAt(n)) < 0) || ((code ^ strData.charAt(n)) > 90))){ code
		 * = (char)((int)code - 1); } char mid = 0; int flag; flag = code ^
		 * strData.charAt(n); if(flag > 93){ mid = 0; } else{ mid =
		 * strKey.charAt(flag); //Asc(Mid(strKey, (code Xor Asc(Mid(strPasswd,
		 * n, 1))) + 1, 1)) } if((code > 35) & (code < 122) & (code != 124) &
		 * (code != 39) & (code != 44) & (mid != 124) & (mid != 39) & (mid !=
		 * 44)){ break; } //确保生成的字符是可见字符并且在SQL语句中有效 } char temp = 0; temp =
		 * strKey.charAt(code ^ strData.charAt(n)); des = des + (char)code +
		 * temp; } strEncode = des; return strEncode;
		 **********************************************************************************************/

		return strData;
	}

	// 把经过加密的文件解密
	public static String DecodeStr(String varCode) {
		/************
		 * 由于与sso的心跳用到发送时加密，从而会不一致，暂时启用****************** int n; String des =
		 * new String(); String strKey = new String(); if((varCode == null) ||
		 * (varCode.length() == 0)){ return ""; }
		 * 
		 * strKey = EncipherConst.m_strKey1 + EncipherConst.m_strKey2 +
		 * EncipherConst.m_strKey3 + EncipherConst.m_strKey4 +
		 * EncipherConst.m_strKey5 + EncipherConst.m_strKey6;
		 * if(varCode.length() % 2 == 1){ varCode = varCode + "?"; } des = "";
		 * for(n = 0; n <= varCode.length() / 2 - 1; n++){ char b; b =
		 * varCode.charAt(n * 2); int a; a =
		 * (int)strKey.indexOf(varCode.charAt(n * 2 + 1)); des = des +
		 * (char)((int)b ^ a); } n = des.indexOf(1); if(n > 0){ return
		 * des.substring(0, n); } else{ return
		 * unicodeToStringForSingleByte(des); }
		 **********************************************************************************************/
		return varCode;
	}

	// @keybyte: encrypt key,length is 8Byte
	// @src: encrypt data
	public static byte[] encryptModeSingleDes(byte[] keybyte, byte[] src) {
		try {
			// Create key
			SecretKey deskey = new SecretKeySpec(keybyte, "DES");
			// encrypt
			Cipher c1 = Cipher.getInstance("DES/ECB/NoPadding");
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);

		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// keybyte: decrypt key,length is 8Byte
	// src: decrypt data
	public static byte[] decryptModeSingleDes(byte[] keybyte, byte[] src) {
		try {
			// Create key
			SecretKey deskey = new SecretKeySpec(keybyte, "DES");
			// decrypt
			Cipher c1 = Cipher.getInstance("DES/ECB/NoPadding");
			c1.init(Cipher.DECRYPT_MODE, deskey);
			// byte[] bRetBytes = c1.doFinal(src);
			// return bRetBytes;
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	public static String getNowDateByFormat(String format) {
		SimpleDateFormat fm = new SimpleDateFormat(format);
		return fm.format(new Date().getTime());
	}

	/*
	 * public static void main(String[] args) { String sKeyMac =
	 * "A35708A65E7ACF90944ECAD35DFC62F3A35708A65E7ACF90"; String sKeyMacData =
	 * "1001110000110001"; byte[] descData =
	 * encryptMode(hexStrToBytes(sKeyMac),hexStrToBytes(sKeyMacData));
	 * System.out.println("MAC:" + bytesToHexStr(descData));
	 * 
	 * String sKeyA = "08D0BC7230D265E7446F9A909F2B52C708D0BC7230D265E7"; String
	 * sKeyAData = "110000110001B301"; descData =
	 * encryptMode(hexStrToBytes(sKeyA),hexStrToBytes(sKeyAData));
	 * System.out.println("KA:" + bytesToHexStr(descData));
	 * 
	 * String sKeyB = "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"; String
	 * sKeyBData = "110000110001B301"; descData =
	 * encryptMode(hexStrToBytes(sKeyB),hexStrToBytes(sKeyBData));
	 * System.out.println("KB:" + bytesToHexStr(descData));
	 * 
	 * String sKeyTac = "C86C4B96D533F81205A0CA09AC65A954C86C4B96D533F812";
	 * String sTacData = "000000000000000000110000111112231234590001000079";
	 * descData = encryptMode(hexStrToBytes(sKeyTac),hexStrToBytes(sTacData));
	 * System.out.println("TAC:" + bytesToHexStr(descData));
	 * 
	 * //String sKeyMac = "A35708A65E7ACF90944ECAD35DFC62F3A35708A65E7ACF90";
	 * //String sKeyMacData = "B3D7F7EDAF75155FEBCB045A947B9D10"; //byte[]
	 * descData =
	 * decryptMode(hexStrToBytes(sKeyMac),hexStrToBytes(sKeyMacData));
	 * //System.out.println("MACDATA:" + bytesToHexStr(descData));
	 * 
	 * 
	 * int a = 655350099; int b = 3/5; System.out.println(a);
	 * System.out.println(b); String sStr="12345";
	 * System.out.println(sStr.subSequence(0, 5));
	 * 
	 * Date dDate = new Date(); SimpleDateFormat dfq = new
	 * SimpleDateFormat("yyyyMMddHHmmssS"); String sMsgSequence =
	 * dfq.format(dDate);
	 * 
	 * System.out.println(sMsgSequence);
	 * System.out.println(String.valueOf(Math.round
	 * (Math.random()*100000)).substring(0,3));
	 * 
	 * String strA = EncodeStr("#" +
	 * "áéíóúñÑabc   d    e     fghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * +
	 * "abccdefghijklmnopqrstuvwxyz1234567890+-abccdefghijklmnopqrstuvwxyz1234567890_=abccdefghijklmnopqrstuvwxyz1234567890"
	 * + "\\\\\\" + "#"); System.out.println("#"+strA+"#"); String strB =
	 * DecodeStr(strA); System.out.println("#"+strB+"#");
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// String sKeyTac = "1122334455667788";
		// String sTacData = "AA022123CC000000";
		// byte[] descData =
		// encryptModeSingleDes(hexStrToBytes(sKeyTac),hexStrToBytes(sTacData));
		// System.out.println("TAC:" + bytesToHexStr(descData));

		// String key = "E4A587FD12B098C7CA25782F345E234CE4A587FD12B098C7";
		// byte[] descData =
		// encryptMode(hexStrToBytes(key),hexStrToBytes("AA022123CC000000"));
		// String aaa = bytesToHexStr(descData);
		// System.out.println("加密后:" + aaa);
		//
		// descData = decryptMode(hexStrToBytes(key),hexStrToBytes(aaa));
		// System.out.println("解密后:" + bytesToHexStr(descData));

		// String a = "AB";
		// byte[] b = a.getBytes();
		// for(int i=0;i<b.length;i++){
		// System.out.println(""+b[i]);
		// }

		// String a = "AB";
		// byte[] b = StrToAsciiBytes(a);
		// for (int i = 0; i < b.length; i++) {
		// System.out.println("" + b[i]);
		// }

		// String a = stringToUnicodeForSingleByte("你好dddfsf");
		// System.out.println("----" + a);

		// String sTmp =
		// "0000000000000000000000000000000000000000000000000000000000000000617364000000000000000000000000000000000000000000000000000000000039393939393937000000000000000000";
		// System.out.println("txtFirstname----"
		// +unicodeToStringForSingleByte(sTmp.substring(0, 32)));
		// System.out.println("txtSecondname----"
		// +unicodeToStringForSingleByte(sTmp.substring(32, 64)));
		// System.out.println("txtSecondname----"
		// +unicodeToStringForSingleByte(sTmp.substring(64, 96)));
		// System.out.println("txtSecondsurname----"
		// +unicodeToStringForSingleByte(sTmp.substring(96, 128)));
		// System.out.println("txtIdNo----"
		// +unicodeToStringForSingleByte(sTmp.substring(128, 160)));

		System.out.println("crc----" + getCRC("000000000111223344000000000008AABBCCDD11223344"));

	}

}
