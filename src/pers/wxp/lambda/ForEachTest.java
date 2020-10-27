package pers.wxp.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wxp
 * @date 2020/10/20
 */
public class ForEachTest {
    @Test
    public void testOne() {
        Stream.generate(Math::random).
                limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void testTwo() {
        Stream.of("this", "is", "a", "stream", "of", "strings")
                .map(String::length)
                .forEach(System.out::println);
    }

    @Test
    public void testThree() {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        strings.forEach(s -> System.out.println(s));
        strings.forEach(System.out::println);
    }

    @Test
    public void testFour() {
        String[] strings = new String[]{"this", "is", "a", "list", "of", "strings"};
        System.out.println(getNamesOfLength(2, strings));

    }

    public String getNamesOfLength(int length, String... names) {
        return Arrays.stream(names)
                .filter(s -> s.length() == length)
                .collect(Collectors.joining(", "));
    }
}
