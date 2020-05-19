package pers.wxp.pattern.strategy;

import org.junit.Test;

import java.util.Date;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/5/19 9:02
 */
public class Client {
    public static void main(String[] args) {
        MarketingPO marketingPO = MarketingPO.builder()
                .id(12)
                .build();
        System.out.println(marketingPO);
    }
    @Test
    public void test() {

    }
}
