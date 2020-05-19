package pers.wxp.gather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuxiaopeng
 * @date 2020-03-18
 */
public class ListDemo {

    public static void main(String[] args) {
        linkedListDemo();
    }

    public static void linkedListDemo() {
        List<String> list = new LinkedList<>();
        list.add("Java");
        list.add("C++");
        list.add("C");
        list.add("Python");
        list.add("Scala");
        list.add("Spring");
        list.remove("Python");
        System.out.println(list);
    }


    public static void removeDemo() {
        List<String> a = new ArrayList<String>(10);
        a.add("1");
        a.add("2");
//		for (String temp : a) {
//			if ("2".equals(temp)) {
//				a.remove(temp);
//			}
//		}
//		System.out.println(a);
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            if (temp == "2") {
                it.remove();
            }
        }
        System.out.println(a);
    }
}


