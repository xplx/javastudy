package pers.wxp.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TDate {
	/**
	 * 获取现在时间
	 * 
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	@Test
	public void getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 格式化的是date日期
		String dateString = formatter.format(currentTime);
		System.out.println(dateString);
	}

	/** 
	* @Description: TODO(将字符串转换成时间的时候，格式化的时间必须和字符串格式相同) 
	* @param: @throws ParseException    
	* @return void     
	*/
	@Test
	public void getShortTime() throws ParseException {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		//格式不相同报错
		DateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		String str = null;
		// String转Date
		str = "2007-1-18";
		date = format1.parse(str);
		//报错
		//date = format2.parse(str);
		//报错，格式不对
		date = format3.parse(str);

	}
}
