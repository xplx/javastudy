package pers.wxp.date;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class TDate {
 /**
 * 锟节伙拷取锟斤拷锟角碉拷前时锟斤拷锟斤拷使锟矫碉拷锟角ｏ拷java.util.Date
 * 锟斤拷锟绞癸拷茫锟紻ate now = new Date(0)锟斤拷取锟斤拷锟斤拷1970锟斤拷锟绞憋拷锟�
 * 使锟斤拷date使锟矫碉拷锟斤拷util.date锟斤拷锟斤拷锟绞癸拷锟絪ql锟斤拷date锟斤拷然锟斤拷取锟侥诧拷锟角碉拷前锟斤拷时锟戒。
 */
@Test
	public void date() {
		
		java.util.Date a = new java.util.Date();
		System.out.println(a);//锟斤拷取锟斤拷锟斤拷英锟侥帮拷时锟斤拷
		
		java.sql.Date b = new java.sql.Date(a.getTime());
		System.out.println("锟斤拷菘锟斤拷锟斤拷锟�"+b);//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷
		
		java.sql.Time c = new java.sql.Time(a.getTime());
		System.out.println("锟斤拷菘锟绞憋拷锟�"+c);//锟斤拷取锟斤拷锟斤拷时锟斤拷
		
		java.sql.Timestamp d=new java.sql.Timestamp(a.getTime());
		System.out.println("锟斤拷取时锟斤拷锟�"+d);//锟斤拷取锟斤拷锟斤拷时锟斤拷锟�
		
		//Date now = new Date(0);//锟斤拷取锟侥诧拷锟角碉拷前锟斤拷时锟斤拷 
		
		DateFormat d2 = DateFormat.getDateTimeInstance(); 
	    String str2 = d2.format(a); //锟斤拷取锟斤拷锟斤拷时锟斤拷锟绞�
		System.out.println("锟斤拷DateFormat.getDateTimeInstance()锟斤拷式锟斤拷时锟斤拷锟轿拷锟�" + str2); 
		
		
		Date da = new Date();  
        System.out.println("new date"+da); 
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");//锟斤拷锟斤拷锟斤拷锟斤拷锟绞撅拷锟绞斤拷锟斤拷锟斤拷锟�
        String dateNowStr = sdf.format(da);  
        System.out.println("锟斤拷式锟斤拷锟斤拷锟斤拷锟斤拷冢锟�" + dateNowStr); 
        
        Calendar now = Calendar.getInstance(); //锟斤拷锟斤拷锟斤拷锟饺★拷锟角帮拷锟斤拷锟斤拷锟� 
        System.out.println("锟斤拷: " + now.get(Calendar.YEAR));  
        System.out.println("锟斤拷: " + (now.get(Calendar.MONTH) + 1) + "");  
        System.out.println("锟斤拷: " + now.get(Calendar.DAY_OF_MONTH));  
        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));  
        System.out.println("锟斤拷: " + now.get(Calendar.MINUTE));  
        System.out.println("锟斤拷: " + now.get(Calendar.SECOND));  
        System.out.println("锟斤拷前时锟斤拷锟斤拷锟斤拷锟�" + now.getTimeInMillis());  
        System.out.println(now.getTime()); 
        
        //姣旇緝鏃堕棿鎴宠绠楀嚭宸��
        
	}
	public static void main(String[] args) {
		
	}
	public void RandomDmoe() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {

		}
	}

}
