package pers.wxp.lambda;

import org.junit.Test;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/5/11 11:26
 */

public class TryTest {

    /**
     * 利用 try-with-resource 语句
     * 所有实现 Closeable 接口的“资源”，
     * 均可采用 try-with-resource 进行简化。
     */
    @Test
    public void TryMethod() {
        //***********************old************************//
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader("cities.csv"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // TODO: 处理line
//            }
//        } catch (IOException e) {
//            System.out.println("读取文件异常" + e);
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    System.out.println("关闭文件异常" + e);
//                }
//            }
//        }

        //***********************new************************//
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // TODO: 处理line
            }
        } catch (IOException e) {
            System.out.println("读取文件异常" + e);
        }
    }

    /**
     * 判空精简
     */
    @Test
    public void isNull() {
        //普通：
        if (Objects.isNull(12)) {
            throw new IllegalArgumentException("用户标识不能为空");
        }

        //精简：
        Assert.notNull(12, "用户标识不能为空");
    }

    /**
     * Optional 值选择工具
     */
    @Test
    public void choiceMethod() {
        Integer value = 1;
        Integer MAX_VALUE = 10;
        Integer thisValue = Optional.ofNullable(value).orElse(12);
        System.out.println(thisValue);

        //filter过滤计算（计算过程：1：判断value不为空。2：判断value值小于等于MAX_VALUE）时取value值。3：否则取other
        Integer getValue = Optional.ofNullable(value).filter(tempValue -> tempValue.compareTo(MAX_VALUE) <= 0).orElse(20);
        System.out.println(getValue);

        //普通：
        //多层判空处理
        //String zipcode = null;
        //if (Objects.nonNull(user)) {
        //    Address address = user.getAddress();
        //    if (Objects.nonNull(address)) {
        //        Country country = address.getCountry();
        //        if (Objects.nonNull(country)) {
        //            zipcode = country.getZipcode();
        //        }
        //    }
        //}

        //精简：
//        String zipcode = Optional.ofNullable(user).map(User::getAddress)
//                .map(Address::getCountry).map(Country::getZipcode).orElse(null);
    }
}
