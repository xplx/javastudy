package pers.wxp.lambda;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author wxp
 * @date 2020-10-20
 */
public class ReduceTest {
    /**
     * 求和
     */
    @Test
    public void ReduceTest() {
        BigDecimal total = Stream.iterate(new BigDecimal("10"), n -> n.add(BigDecimal.ONE))
                .limit(10)
                .reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val));
        System.out.println("The total is " + total);
    }

    /**
     * 排序
     */
    @Test
    public void ReduceTestOne() {
        List<String> strings = Arrays.asList(
                "this", "is", "a", "list", "of", "strings");

        List<String> sorted = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(toList());
        sorted.forEach(south -> {
            System.out.println(south);
        });
    }

    /**
     * 单列求和
     */
    @Test
    public void ReduceTestTwo() {
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    /**
     * 双列求和
     */
    @Test
    public void ReduceTestThree() {
        int sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x=%d, y=%d%n", x, y);
                    return x + y;
                }).orElse(0);
        System.out.println("求和" + sum);
    }

    /**
     * 双列求和
     */
    public int sumDoublesDivisibleBy3(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .sum();
    }
}
