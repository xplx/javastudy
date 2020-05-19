package pers.wxp.type.string;

import java.io.UnsupportedEncodingException;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/20 14:32
 */
public class StringFormat {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String ss = "\\u60A8";
        ss = deUnicode(ss);
        System.out.println(ss);
    }

    public static String deUnicode(String str) {
        byte[] bytes = new byte[str.length() / 2];
        byte tempByte = 0;
        byte tempHigh = 0;
        byte tempLow = 0;
        for (int i = 0, j = 0; i < str.length(); i += 2, j++) {
            tempByte = (byte) (((int) str.charAt(i)) & 0xff);
            if (tempByte >= 48 && tempByte <= 57) {
                tempHigh = (byte) ((tempByte - 48) << 4);
            } else if (tempByte >= 97 && tempByte <= 101) {
                tempHigh = (byte) ((tempByte - 97 + 10) << 4);
            }
            tempByte = (byte) (((int) str.charAt(i + 1)) & 0xff);
            if (tempByte >= 48 && tempByte <= 57) {
                tempLow = (byte) (tempByte - 48);
            } else if (tempByte >= 97 && tempByte <= 101) {
                tempLow = (byte) (tempByte - 97 + 10);
            }
            bytes[j] = (byte) (tempHigh | tempLow);
        }
        String result = null;
        try {
            result = new String(bytes, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
