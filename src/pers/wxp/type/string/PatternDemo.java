package pers.wxp.type.string;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 模式
 */
public class PatternDemo {
    @Test
    public void patternDemo() {
        Pattern pattern = Pattern.compile("Java");

        //返回此模式的正则表达式即Java
        System.out.println(pattern.pattern());
        //根据匹配模式拆分输入序列的方法
        Pattern pattern1 = Pattern.compile("Java");
        String test = "123Java456Java789Java";
        String[] result = pattern1.split(test);
        for (String s : result)
            System.out.println(s);
        Pattern pattern2 = Pattern.compile("Java");
        String test1 = "123Java456Java789Java";
        String[] result1 = pattern2.split(test1, 2);
        for (String s : result1) {
            System.out.println(s);
        }
    }

    /**
     * Pattern类也自带一个静态匹配方法matches(String regex, CharSequence input)，但只能进行全字符串匹配并且只能返回是否匹配上的boolean值
     */
    @Test
    public void patternDemo1() {
        String test1 = "Java";
        String test2 = "Java123456";

        System.out.println(Pattern.matches("Java", test1));//返回true
        System.out.println(Pattern.matches("Java", test2));//返回false

        Pattern pattern = Pattern.compile("Java");
        String test = "123Java456Java789Java";
        Matcher matcher = pattern.matcher(test);
        System.out.println(matcher.matches());
    }
}
