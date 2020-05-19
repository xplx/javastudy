package pers.wxp.junit4;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jSendMail {
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties ");
		Logger logger = Logger.getLogger(Log4jSendMail.class);
		logger.info("123");
		logger.error("hello");
		System.out.println("info");
	}
}
