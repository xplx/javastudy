package pers.wxp.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author wxp
 * @Date 2020-11-06
 */
public class HeapMemory {
    public static void main(String[] args) {
        MyItem obj = new MyItem();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
