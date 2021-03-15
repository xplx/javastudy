package pers.wxp.type.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wxp
 * @date 2021/3/15
 */
public class HashMapTest {
    @Test
    public void HashMapMethod() {
        Map<String, Object> m = new HashMap();
        m.put("a", 1);
        Map concurrentMap = new ConcurrentHashMap();
    }

    void resize(int newCapacity){
        Map.Entry[] oldEntries = new Map.Entry[newCapacity];
    }
}
