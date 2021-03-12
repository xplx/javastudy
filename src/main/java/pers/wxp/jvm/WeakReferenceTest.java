package pers.wxp.jvm;

import java.lang.ref.WeakReference;

/**
 *
 * @author lenovo
 * @date 2020-11-10
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        //弱引用
        WeakReference<String> weakReference = new WeakReference<String>(new String("hello"));
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }
}
