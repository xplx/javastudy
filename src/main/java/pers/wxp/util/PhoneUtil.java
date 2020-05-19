package pers.wxp.util;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wuxiaopeng
 * @create 2018-04-26 19:41
 **/

public class PhoneUtil {
    public static void main(String[] args) {
        String phone = "12123456789";
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if(phone.length() != 11){
            System.out.println("手机号应为11位数");
        }else{
            //Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,
            Pattern p = Pattern.compile(regex);
            //返回一个Matcher对象
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if(isMatch){
                System.out.println("您的手机号" + phone + "是正确格式@——@");
            } else {
                System.out.println("您的手机号" + phone + "是错误格式！！！");
            }
        }
    }
    @Test
    public void pattern1(){
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("aaa2223bb");
        m.find();//匹配2223
        m.start();//返回3
        m.end();//返回7,返回的是2223后的索引号
        m.group();//返回2223
    }
}   