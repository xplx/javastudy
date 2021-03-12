package pers.wxp.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author wxp
 */
public class ParallelStreamTest {
    public static void main(String[] args) throws InterruptedException {
        List<Apple> appleList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Random r = new Random(500000);
            Apple apple = new Apple(r.nextDouble(), r.nextDouble());
            appleList.add(apple);
        }
        Date begin = new Date();
//        for (Apple apple : appleList) {
//            apple.setPrice(5.0 * apple.getWeight() / 1000);
//            Thread.sleep(1000);
//        }
        appleList.parallelStream().forEach(apple ->
                {
                    apple.setPrice(5.0 * apple.getWeight() / 1000);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        Date end = new Date();
        System.out.println("耗时：{}" + (end.getTime() - begin.getTime()) / 1000);
    }

    static class Apple {
        private Double weight;
        private Double price;

        public Apple(Double weight, Double price) {
            this.weight = weight;
            this.price = price;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}
