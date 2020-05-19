package pers.wxp.lambda;

import org.junit.Test;
import pers.wxp.thread.security.Account;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wuxiaopeng
 * @description:流（Stream）是Java 8的新成员，
 * 允许你以声明式处理数据集合，可以看成为一个遍历数据集的高级迭代器。
 * 流主要有三部分构成：获取一个数据源→数据转换→执行操作获取想要的结果。
 * 每次转换原有 Stream 对象不改变，返回一个新的 Stream 对象，
 * 这就允许对其操作可以像链条一样排列，形成了一个管道。
 * 流（Stream）提供的功能非常有用，主要包括匹配、过滤、汇总、转化、分组、分组汇总等功能。
 * @date 2020/5/11 14:00
 */
public class StreamTest1 {
    @Test
    public void getListValue() {
        List<String> list = new ArrayList<>();
        list.add("a");
        boolean isFound = false;
        //普通：
        for (String s : list) {
            if (Objects.equals(s, "a")) {
                isFound = true;
                break;
            }
        }
        System.out.println(isFound);

        //精简：(获取集合里面的值和现有值比较)
        isFound = list.stream().anyMatch(string -> Objects.equals(string, "a"));
        System.out.println(isFound);


    }

    /**
     * 过滤集合数据
     */
    @Test
    public void newCollectFilter() {
        List<String> list = new ArrayList<>();
        list.add("a");
        //普通：
        List<String> resultList = new ArrayList<>();
        for (String user : list) {
            //Boolean.TRUE.equals不去定义中间变量
            if (user.equals("a")) {
                resultList.add(user);
            }
        }
        System.out.println(resultList);

        //精简：
        List<String> streamList = list.stream()
                .filter(string -> string.equals("b"))
                .collect(Collectors.toList());
        System.out.println(streamList);
    }

    @Test
    public void sumStream() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("wxp", 123.5f));
        accountList.add(new Account("zz", 12.0f));

        //普通:
        double total = 0.0D;
        for (Account account : accountList) {
            total += account.getBalance();
        }
        System.out.println(total);

        //精简
        double totalStr = accountList.stream().mapToDouble(Account::getBalance).sum();
        System.out.println(totalStr);
    }

    /**
     * 转化集合数据
     */
    @Test
    public void changeStream() {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        List<String> stringList1 = new ArrayList<>();
        for (String s : stringList) {
            stringList1.add(s);
        }

        //map过滤条件
        List<String> userVOList = stringList.stream().map(s -> s).collect(Collectors.toList());
        System.out.println(userVOList);
    }

    /**
     * 分组集合数据
     */
    @Test
    public void groupStream() {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("a");
        stringList.add("a");
        stringList.add("b");
        stringList.add("b");
        Map<String, List<String>> roleUserMap = new HashMap<>();
        for (String userDO : stringList) {
            roleUserMap.computeIfAbsent(userDO, key -> new ArrayList<String>())
                    .add(userDO);
        }
        System.out.println(roleUserMap);

        //精简
        stringList.add("c");
        Map<String, List<String>> roleUserMapS = stringList.stream()
                .collect(Collectors.groupingBy(key -> key)); //UserDO::getRoleId(获取对象值)
        System.out.println(roleUserMapS);
    }

    /**
     * 分组汇总集合
     */
    @Test
    public void groupSumStream() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("wxp", 123.5f));
        accountList.add(new Account("wxp", 13.5f));
        accountList.add(new Account("zz", 12.0f));
        Map<String, Double> nameTotalMap = new HashMap<>();
        for (Account account : accountList) {
            String name = account.getName();
            Double total = Optional.ofNullable(nameTotalMap.get(name)).orElse(0.0D);
            nameTotalMap.put(name, total + account.getBalance());
        }
        System.out.println(nameTotalMap);
    }

    /**
     * 生成范围集合
     */
    @Test
    public void rangeStream(){
        int N = 10;
        int[] array1 = new int[N];
        for (int i = 0; i < N; i++) {
            array1[i] = i + 1;
        }

        int[] array2 = new int[N];
        array2[0] = 1;
        for (int i = 1; i < N; i++) {
            array2[i] = array2[i - 1] * 2;
        }
        System.out.println(array1);
        System.out.println(array2);


        int[] array3 = IntStream.rangeClosed(1, N).toArray();
        int[] array4 = IntStream.iterate(1, n -> n * 2).limit(N).toArray();

    }
}
