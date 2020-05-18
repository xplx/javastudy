package pers.wxp.gather;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/18 15:40
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        //Map<String, Integer> concurrentHashMap = new ConcurrentHashMap();
        //Map<String, Integer> concurrentHashMap = new HashMap<>();
        Map<String, Integer> concurrentHashMap = new LinkedHashMap<>();
        for (int i = 0; i < 1000000; i++) {
            concurrentHashMap.put("key" + i, i);
        }
        long b = System.currentTimeMillis();
        System.out.println("循环时间：" + (b - a));
    }
}
