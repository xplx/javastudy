package pers.wxp.type.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wxp
 * @date 2021-3-4
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        //putIfAbsent   如果传入key对应的value已经存在，
        // 就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null
        Map<Object,Boolean> map = new ConcurrentHashMap<>();
        System.out.println(map.putIfAbsent("a", true));
        System.out.println(map.putIfAbsent("a", true));
        System.out.println(map.putIfAbsent("a", true));
    }
}
