package pers.wxp.jna;

import org.junit.Test;

public class TestTest {
    @Test
    public void MultiThreadTest(){
        new Thread(()->{
            System.out.println("线程1");
        }).start();
        new Thread(()->{
            System.out.println("线程2");
        }).start();
        new Thread(()->{
            System.out.println("线程3");
        }).start();
    }

    public static void main(String[] args) {
        System.out.println(Math.round(-1.5));
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        int[] values = {1, 2, 3};
    }
}
