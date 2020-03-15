package pers.wxp.util;


import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class SendMessage {
	private static Logger log = Logger.getLogger("短信发送");

	// 容联云通讯地址
	public static String INIT_ADD = "";
	// 容联云通讯端口
	public static String INIT_POINT = "";
	// 容联云通讯账户SID
	public static String ACOUNT_SID = "";
	// 容联云通讯账户token
	public static String AUTH_TOKEN = "";
	// 容联云通讯应用ID
	public static String APP_ID = "";
	// 容联云通讯短息模板ID
	public static String TEMPLATE_ID = "";
	// 容联云通讯短息有效时间
	public static String EFFECTIVE_TIME = "";

	static {
		try {
			Properties props = new Properties();
			props.load(SendMessage.class.getClassLoader().getResourceAsStream(
					"config.properties"));
			INIT_ADD = props.getProperty("initAdd");
			INIT_POINT = props.getProperty("initPoint");
			ACOUNT_SID = props.getProperty("acountSid");
			AUTH_TOKEN = props.getProperty("authToken");
			APP_ID = props.getProperty("appId");
			TEMPLATE_ID = props.getProperty("templateId");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getSMSVerificationCode(String telNumber,
			Integer captcha, String effcctive_time) {
		try {
			// 调用短信验证平台
			HashMap<String, Object> result = null;
			CCPRestSmsSDK restAPI = new CCPRestSmsSDK();   
			restAPI.init(INIT_ADD, INIT_POINT);
			restAPI.setAccount(ACOUNT_SID, AUTH_TOKEN);
			restAPI.setAppId(APP_ID);
			// 调用发送模板短信的接口发送短信
			result = restAPI.sendTemplateSMS(telNumber, TEMPLATE_ID,
					new String[] { String.valueOf(captcha), effcctive_time });
			log.info("result=" + result);
			if("000000".equals(result.get("statusCode"))){
				return "9000";
			} 
			return "9999";
			
//			return "9000";
		} catch (Exception e) {
			log.error("发送短信失败!", e);
			return "9999";
		}
	}
	public static void main(String[] args) {
		// 设置随机数
		Random random = new Random();
		int x = random.nextInt(900000);
		int captcha = x + 100000;
		getSMSVerificationCode("18516600474",captcha,"5");
	}
}

