package pers.wxp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lenovo
 */
public class LogPrintUtil {
    public static void print(String param) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
        System.out.println(param + ":" + sdf.format(new Date()));
    }

    public static void main(String[] args) {
        print("kaishi");
    }
}
