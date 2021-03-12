package pers.wxp.type.number;

import org.junit.Test;

import java.util.Random;

/**
 * @author wuxiaopeng
 * @create 2018-04-21 17:50
 **/

public class RandomDemo {
    @Test
    public void randomDemoTest(){
        Random random = new Random();
       int rand = random.nextInt(999999);
        System.out.println("rand:"+rand);
    }
}   