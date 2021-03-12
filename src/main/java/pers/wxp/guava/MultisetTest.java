package pers.wxp.guava;

import org.openjdk.jol.util.Multiset;

/**
 * @author wxp
 * @date 2020-12-21
 */
public class MultisetTest {
    public static void main(String[] args) {
        Multiset<String> multiset = new Multiset();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("a");
        multiset.add("c");
        System.out.println(multiset.size());
        //跟踪每个对象数量
        System.out.println(multiset.count("a"));
    }
}
