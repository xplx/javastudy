package pers.wxp.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TimeCompare {

	@Test
	public void TimeDifference() throws ParseException {
		java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Calendar c = Calendar.getInstance();
        String date1 = "2015-10-10 00:00:1";
        String date2 = "2015-10-10 00:00:1";
        c.setTime(sdf.parse(date1));
        int y1 = c.get(Calendar.YEAR);
        int m1 = c.get(Calendar.MONTH);
         
         
        c.setTime(sdf.parse(date2));
        int y2 = c.get(Calendar.YEAR);
        int m2 = c.get(Calendar.MONTH);
         
        int y = Math.abs(y2 - y1);
        int m = y * 12 + Math.abs(m1-m2);
 
        long d1 = sdf.parse(date1).getTime();
        long d2 = sdf.parse(date2).getTime();
        int d = (int) (Math.abs(d2-d1) / (1000 * 60 * 60 * 24));
         
        System.out.println("相差: " + y);
        System.out.println("相差月: " + m);
        System.out.println("相差: " + d);
        System.out.println("相差: " + d);
        
        String time1 = "2015-5-4 12:15:17";
        String time2 = "2015-5-4 12:15:11";
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        Date date3 = sdf1.parse(time1);
        Date date4 = sdf1.parse(time2);
        
        long date = date3.getTime() - date4.getTime();
        
        System.out.println(date);
		
	}
	@Test
	public void StringTimestample(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒 
		Timestamp now = new Timestamp(System.currentTimeMillis());//获取系统当前时间 
		System.out.println(now);
		String str = df.format(now);
		System.out.println(str);
	}
}
