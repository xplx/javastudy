package pers.wxp.util;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeJudge {

	static String  hexString = "0123456789ABCDEF";
	
    public static boolean isIp(String ipAddress){
    	String test = "([1-9]|[1-9]\\d|1\\d{2}|2[0-1]\\d|22[0-3])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pattern = Pattern.compile(test);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }
	
	public static boolean isHexString(String str){
		String sC;
		for (int i=0;i<str.length();i++) {
			sC = str.substring(i, i+1).toUpperCase();
			if (hexString.indexOf(sC) < 0)
			   return false;
		}
        return true;
	}	
	public static boolean isNumeric(String str){ 
		if(str.matches("\\d*")){
		  return true; 
		}else{
		  return false;
		}
	}

	public static boolean isDouble(String str){ 
		double dVar = 0;
		try {
			dVar = Double.parseDouble(str);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
    public static boolean isValidDate(String s)
    {
        try
        {
        	if (s.equals("0000-00-00 00:00:00") || s.equals("0000-00-00")) {
        		return false;
        	}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.parse(s);
            return true;
         }
        catch (Exception e)
        {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

}
