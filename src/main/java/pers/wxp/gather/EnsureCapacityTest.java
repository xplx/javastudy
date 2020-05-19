package pers.wxp.gather;

import java.util.ArrayList;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/18 16:15
 */
public class EnsureCapacityTest {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>(1);
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前：" + (endTime - startTime));

        list = new ArrayList<Object>();
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后：" + (endTime1 - startTime1));
    }
}
