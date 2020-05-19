package pers.wxp.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/5/18 9:29
 */
public class Client {
    public static void main(String[] args) {
        //写一个函数接口指向Lambda表达式，主要为了看到lambda表达式在传递时候的状态
        //可以参数类型
        //MyFunctionInterface<String> myFunctionInterface = (String t1) -> p.setAge(1);
        //匿名函数类
        pers.wxp.lambda.MyFunctionInterface myFunctionInterface = (s, v) -> {
            return s + v;
        };
        String a = myFunctionInterface.doSome("a", "b");
        System.out.println(a);
        pers.wxp.lambda.MyFunctionInterface<String> myFunctionInterface2 = (t1, t2) -> "qw";
        System.out.println(myFunctionInterface2.doSome("a", "b"));
    }

    @Test
    public void consumerTest() {
        Consumer<String> consumer = s -> System.out.println(s);
        //lambda特殊表达式
        Consumer<String> consumer1 = System.out::println;
        consumer.accept("a");
        consumer1.accept("b");
    }

    @Test
    public void supplierTest() {
        //普通的lambda
        Supplier<String> supplier1 = () -> "nice";
        String s1 = supplier1.get();

        //特殊的lambda
        Supplier<String> supplier2 = String::new;
        String s2 = supplier2.get();
        //打印s1
        System.out.println(s1);
        //打印s2
        System.out.println(s2);
    }

    @Test
    public void functionTest() {
        //接受一个值，返回一个Boolean值
        Function<Integer, Boolean> function = (i) -> {
            if (i > 1) {
                return true;
            } else {
                return false;
            }
        };
        Boolean result = function.apply(3);
        System.out.println(result);

        //接受一个值，返回一个Boolean值
        Function<Integer, Integer> function1 = i -> {
            if (i > 4) {
                return 1;
            } else {
                return 2;
            }
        };

        Function<Integer, Integer> function2 = i -> i * i;
        //在function2执行之前，先执行function1,猜测一下  1小于4返回2，2*2 = 4
        Integer integer = function2.compose(function1).apply(1);
        System.out.println(integer);


        //在function1执行之前，先执行function2,猜测一下  1*1 = 1 ,比4小返回2
        Integer integer2 = function1.compose(function2).apply(1);
        System.out.println(integer2);
    }

    @Test
    public void streamTest() {
        List<String> testData = new ArrayList<String>();
        testData.add("张三");
        testData.add("李四");
        testData.add("王二");
        testData.add("麻子");
        List<String> a = testData.stream()
                //过滤掉false
                .filter(x -> !x.startsWith("张")).collect(Collectors.toList());
        System.out.println(a);

        List<Integer> b = testData.stream()
                //map转换结果使用
                .map(x -> x.length()).collect(Collectors.toList());
        System.out.println(b);

        /**
         * flatMap和map都是使用Function接口,
         * 不同的是返回值flatMap限定为Stream类型.
         * 所以flatMap可以作为合并流使用,如以下代码,提取出所有的字符.
         */
        List<String> c = testData.stream()
                .flatMap(x -> Stream.of(x.split("")))
                .collect(Collectors.toList());
        System.out.println(c);
    }
}
