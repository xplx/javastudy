package pers.wxp.util;

import java.io.File;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class ConversionUtil {

	/**
	 * hex ASCII code conversion to String. for example: input: 61626364656667686931 output:abcdefghi1
	 * 
	 * @throws Exception
	 */
	public static String hexStrToStr(String hexStr) throws Exception {
		hexStr = wipeOffSpace(hexStr);
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

	public static String get00(int len) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			sb.append("00");
		}
		return sb.toString();
	}

	/**
	 * 将16进制的芯片号转化成10位10进制的数，不够前面用0补齐
	 * 
	 * @param hexCardNo
	 * @return
	 */
	public static String dealHexCardNo(String hexCardNo) {
		return ConversionUtil.complete00(String.valueOf(Long.parseLong(hexCardNo, 16)), 10, "0", true);
	}

	public static String trimspace(String src) {
		return src.replaceAll(" ", "");
	}

	public static byte[] hexstr2byte(String inData) {
		byte[] temp = new byte[inData.length() / 2];
		for (int i = 0; i < inData.length() / 2; i++) {
			temp[i] = (byte) Integer.parseInt(inData.substring(i * 2, i * 2 + 2), 16);
		}
		return temp;
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

	static String hexString = "0123456789ABCDEF";

	public static boolean isHexString(String str) {
		String sC;
		for (int i = 0; i < str.length(); i++) {
			sC = str.substring(i, i + 1).toUpperCase();
			if (hexString.indexOf(sC) < 0)
				return false;
		}
		return true;
	}

	/**
	 * hex string conversion to byte array,output byte used base complement. for example: input: abcdef output:-85 -51 -17
	 */
	public static byte[] hexStrToBytes(String src) {
		src = wipeOffSpace(src);
		if (!isHexString(src)) {
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

	/**
	 * Wipe off space for string
	 * 
	 * @param str
	 * @return str
	 */
	public static String wipeOffSpace(String str) {
		String retStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (!str.substring(i, i + 1).equals(" ")) {
				retStr = retStr + str.substring(i, i + 1);
			}
		}
		return retStr;
	}

	/**
	 * hex char conversion to byte,output byte used base complement. for example: input: src0=a src1=b output:-85
	 */
	private static byte uniteBytes(String src0, String src1) {
		byte b0 = Byte.decode("0x" + src0).byteValue();
		b0 = (byte) (b0 << 4);
		byte b1 = Byte.decode("0x" + src1).byteValue();
		byte ret = (byte) (b0 | b1);
		return ret;
	}

	/**
	 * String conversion to hex ASCII code. for example: input: abcdefghi1 output:61626364656667686931
	 */
	public static String strToHexStr(String str) {
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

	public static String byte2hex(byte[] readdat) {
		StringBuffer sb = new StringBuffer();
		String t = "";
		for (int i = 0; i < readdat.length; i++) {
			t = Integer.toHexString(readdat[i]);
			if (t.length() == 1) {
				sb.append("0" + t);
			} else if (t.length() > 2) {
				sb.append(t.substring(t.length() - 2, t.length()));
			} else {
				sb.append(t);
			}
		}
		return sb.toString();
	}

	/*
	 * byte 转为2个十六进制字符
	 */
	public static byte[] hex2asc(byte dat) {
		String temp = Integer.toHexString(dat);
		if (temp.length() == 1) {
			temp = "0" + temp;
		} else if (temp.length() > 2) {
			temp = temp.substring(temp.length() - 2);
		}
		return temp.getBytes();
	}

	public static String byte2str(byte b) {
		String temp = Integer.toHexString(b);
		if (temp.length() == 1) {
			temp = "0" + temp;
		} else if (temp.length() > 2) {
			temp = temp.substring(temp.length() - 2);
		}
		return temp;
	}

	/*
	 * 16进制字符转byte
	 */
	public static void str2hex(byte[] inData, byte[] outData) {
		String temp = new String(inData);
		for (int i = 0; i < outData.length; i++) {
			outData[i] = (byte) Integer.parseInt(temp.substring(i * 2, i * 2 + 2), 16);
		}
	}

	public static void str2hex(byte[] inData, byte[] outData, int outLen) {
		String temp = new String(inData);
		for (int i = 0; i < outLen; i++) {
			outData[i] = (byte) Integer.parseInt(temp.substring(i * 2, i * 2 + 2), 16);
		}
	}

	public static void str2hex(byte[] inData, int start, byte[] outData, int outLen) {
		String temp = new String(inData).substring(start);
		for (int i = 0; i < outLen; i++) {
			outData[i] = (byte) Integer.parseInt(temp.substring(i * 2, i * 2 + 2), 16);
		}
	}

	public static void str2hex(byte[] inData, int s1, byte[] outData, int s2, int len) {
		String temp = new String(inData).substring(s1);
		for (int i = 0; i < len; i++) {
			outData[i + s2] = (byte) Integer.parseInt(temp.substring(i * 2, i * 2 + 2), 16);
		}
	}

	public static void hexstr2byte(String inData, int s1, byte[] outData, int s2, int len) {
		String temp = inData.substring(s1);
		for (int i = 0; i < len; i++) {
			outData[i + s2] = (byte) Integer.parseInt(temp.substring(i * 2, i * 2 + 2), 16);
		}
	}

	public static void memcpy(byte[] dest, int s1, byte[] src, int s2, int len) {
		if (len > src.length - s2) {
			byte[] temp = new byte[len];
			for (int i = 0; i < len - (src.length - s2); i++) {
				temp[i] = 0;
			}
			for (int i = 0; i < src.length - s2; i++) {
				temp[i + (len - (src.length - s2))] = src[i + s2];
			}
			for (int i = 0; i < len; i++) {
				dest[i + s1] = temp[i];
			}
		} else {
			for (int i = 0; i < len; i++) {
				dest[i + s1] = src[i + s2];
			}
		}
	}

	public static byte[] hex2byte(String strhex) {
		if (strhex == null) {
			return null;
		}
		int l = strhex.length();
		if (l % 2 == 1) {
			return null;
		}
		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; i++) {
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
		}
		return b;
	}

	public static void byte2hex(byte[] readdat, int s1, byte[] dest, int s2, int len) {
		for (int i = 0; i < len; i++) {
			byte[] temp = hex2asc(readdat[i + s1]);
			dest[i * 2 + s2] = temp[0];
			dest[i * 2 + 1 + s2] = temp[1];
		}
	}

	public static void hex2str(byte[] sour, byte[] dest) {

		for (int i = 0; i < 8; i++) {
			byte[] te = hex2asc(sour[i]);

			dest[i * 2] = te[0];
			dest[i * 2 + 1] = te[1];
		}
	}

	public static int hex2int(byte[] inData) {
		return Integer.parseInt(new String(inData), 16);
	}

	public static String xHex(String lsData) {
		String xLsData = "";
		for (int i = 0; i < lsData.length(); i++) {
			xLsData += Integer.toHexString(15 - Integer.parseInt(lsData.substring(i, i + 1), 16));
		}
		return xLsData;
	}

	public static String xHex(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return null;
		}
		byte[] b1 = hexstr2byte(s1);
		byte[] b2 = hexstr2byte(s2);
		byte[] res = new byte[b1.length];
		for (int i = 0; i < b2.length; i++) {
			res[i] = (byte) (b1[i] ^ b2[i]);
		}
		return byte2hex(res);
	}

	public static void xHex(byte[] data, byte[] noData) {
		char hex_table[] = { 'F', 'E', 'D', 'C', 'B', 'A', '9', '8', '7', '6', '5', '4', '3', '2', '1', '0' };
		for (int i = 0; i < data.length; i++) {
			noData[i] = (byte) (hex_table[Integer.parseInt((char) data[i] + "", 16)]);
		}
	}

	// me
	public static int atoi(byte[] bytes) {
		try {
			int i = Integer.parseInt(new String(bytes));
			return i;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static int atoi(String bytes) {
		try {
			int i = Integer.parseInt(bytes);
			return i;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	// C func
	public static void strcat(byte[] dest, byte[] data) {
		dest = (new String(dest).trim() + new String(data).trim()).getBytes();
	}

	public static String trimSpace(String cmd) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < cmd.length(); i++) {
			if (cmd.charAt(i) != ' ') {
				sb.append(cmd.charAt(i));
			}
		}
		return sb.toString();
	}

	public static String complete00(String src, int toLen, String str, boolean isHead) {
		String ret = src;
		int temp = toLen - src.length();
		for (int i = 0; i < temp; i++) {
			if (isHead) {
				ret = str + ret;
			} else {
				ret = ret + str;
			}
		}
		return ret;
	}

	public static String complete00(String src, int len) {
		return complete00(src, len, "0", true);
	}

	public static String hexPlusInt(String hex, int toPlus) {
		return Integer.toHexString(Integer.parseInt(hex, 16) + toPlus);
	}

	public static String toReadOldM1Name(String src) {
		String res = "";
		if (src.length() != 16) {
			return null;
		}
		for (int i = 0; i < 4; i++) {
			res += new String(new byte[] { (byte) Integer.parseInt(src.substring(i * 4, i * 4 + 2), 16),
					(byte) Integer.parseInt(src.substring(i * 4 + 2, i * 4 + 4), 16) }).trim();
		}
		return res;
	}

	public static String toWriteOldM1Name(String src) {
		String res = "";
		if (src.length() > 4) {
			return null;
		}
		for (int i = 0; i < src.length(); i++) {
			res += complete00(byte2hex(src.substring(i, i + 1).getBytes()), 4);
		}
		return complete00(res, 16);
	}

	/**
	 * split的返过程。将数组导出字符串，按separator分割
	 * 
	 * @param array
	 *            数组
	 * @param separator
	 *            分隔符
	 * @return
	 */
	public static String join(Object array[], char separator) {
		if (array == null)
			return null;
		return join(array, separator, 0, array.length);
	}

	private static String join(Object array[], char separator, int startIndex, int endIndex) {
		if (array == null)
			return null;
		int bufSize = endIndex - startIndex;
		if (bufSize <= 0)
			return "";
		bufSize *= (array[startIndex] != null ? array[startIndex].toString().length() : 16) + 1;
		StringBuffer buf = new StringBuffer(bufSize);
		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex)
				buf.append(separator);
			if (array[i] != null)
				buf.append(array[i]);
		}
		return buf.toString();
	}

	public static String makePublishPW(String hexCardNo) {
		hexCardNo = complete00(hexCardNo, 8);
		return hexCardNo + hexCardNo.substring(0, 4);
	}

	public static String makeVerify(String src) {
		byte[] temp = hexstr2byte(src);
		byte b15 = temp[0];
		for (int i = 1; i < 15; i++) {
			b15 = (byte) (b15 ^ temp[i]);
		}
		return src.substring(0, 30) + shex(b15);
	}

	public static String shex(int val) {
		String temp = Long.toHexString(val);
		String ret = "";
		switch (temp.length()) {
		case 1:
			ret = "0" + temp;
			break;

		default:
			ret = temp.substring(temp.length() - 2, temp.length());
			break;
		}
		return ret;
	}

	// 将int转为long，卡号超出了int的范围
	public static long int2long(int val) {
		byte[] temp = new byte[4];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = (byte) ((val >> i * 8) & 0xFF);
		}
		String cardNo = "";
		for (int i = temp.length - 1; i >= 0; i--) {
			cardNo += shex(temp[i]);
		}
		return Long.parseLong(cardNo, 16);
	}

	/**
	 * append string in str
	 * 
	 * @param str
	 *            Format:must HEX Code, and string is 2 multiple.
	 * @return
	 */
	public static String supply00(String sOldStr, int SupplyWay, String SupplyChar, int SupplyNum) {
		if (SupplyWay == 0) {
			return complete00(sOldStr, SupplyNum, SupplyChar, true);
		}
		return complete00(sOldStr, SupplyNum, SupplyChar, false);
	}

	public static String DoubleToString(Double inputValue) {
		String sRet;
		NumberFormat currencyFormat = NumberFormat.getNumberInstance();
		sRet = StringFormat(currencyFormat.format(inputValue));
		return sRet;
	}

	public static Double StringToDouble(String inputValue) {
		Double dTmp = 0.00;
		if (inputValue == null || inputValue.equals(""))
			return dTmp;
		NumberFormat currencyFormat = NumberFormat.getNumberInstance();
		try {
			dTmp = currencyFormat.parse(inputValue).doubleValue();
		} catch (ParseException e) {
			dTmp = 0.00;
			e.printStackTrace();
		}
		return dTmp;
	}

	public static String StringFormat(String inputValue) {
		Double dTmp = 0.00;
		String resultValue = "";
		if (inputValue != null && !inputValue.equals("")) {
			NumberFormat currencyFormat = NumberFormat.getNumberInstance();
			try {
				dTmp = currencyFormat.parse(inputValue).doubleValue();
			} catch (ParseException e) {
				dTmp = 0.00;
				e.printStackTrace();
			}
			resultValue = String.format("%.2f", dTmp);
		}
		return resultValue;
	}

	public static boolean isNumeric(String str) {// 验证字符串中包含的是否全是数字
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 获取路径
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String getFilePath(String memu, String fileName) throws Exception {
		if (fileName == null || fileName.equals("")) {
			return ConversionUtil.class.getClassLoader().getResource(memu).getPath();
		}
		return ConversionUtil.class.getClassLoader().getResource(memu + File.separator + fileName).getPath();
	}

	/**
	 * 获取32位uuid
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getLoginIp(HttpServletRequest request) {
		String ip = null;
		ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1")) {
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}

		}

		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}

	/**
	 * 如果是null，返回空串
	 * 
	 * @param obj
	 * @return
	 */
	public static String isNullReturnStr(Object obj) {
		if (obj == null)
			return "";
		return obj.toString();
	}

	/**
	 * 获取16位虚拟卡号
	 * 
	 * @return
	 */
	public static String getCardAsn() {
		String tempCode = ThreadLocalRandom.current().nextLong() + "";
		String random = tempCode.substring(tempCode.length() - 16, tempCode.length());
		while (random.indexOf("-") > -1) {
			random = tempCode.substring(tempCode.length() - 16, tempCode.length());
		}
		return random;
	}

	/**
	 * 转化字符串数组为分隔符隔开的字符串
	 * 
	 * @param array
	 * @param splitStr
	 *            分隔符
	 * @return 逗号隔开的字符串 如: 1#a#b
	 */
	public static String toSplitString(String[] array, String splitStr) {
		if (array == null || array.length == 0) {
			return null;
		}
		StringBuffer rtnStr = new StringBuffer();
		for (String tmp : array) {
			rtnStr.append(tmp).append(splitStr);
		}
		return rtnStr.toString().substring(0, rtnStr.toString().length() - 1);
	}

	/**
	 * BigInteger转16进制字符串
	 * 
	 * @param data
	 * @return
	 */
	public static String bigIntegerTOHexForString(BigInteger data) {
		return data.toString(16).toUpperCase();
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key) == null ? "" : params.get(key).toString();

			if (value == null || "".equals(value.trim()) || "null".equalsIgnoreCase(value.trim()) || "\"null\"".equalsIgnoreCase(value.trim())) {
				continue;
			}

			prestr = prestr + key + "=" + value + "&";
		}
		if (prestr.endsWith("&")) {
			prestr = prestr.substring(0, prestr.length() - 1);
		}
		return prestr;
	}

	/**
	 * 获取pan的分散因子
	 * 
	 * @param pan
	 * @return
	 */
	public static String getLsDataForEp(String pan) {
		return pan.substring(pan.length() - 16, pan.length());
	}
}
