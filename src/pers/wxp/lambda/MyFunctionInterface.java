package pers.wxp.lambda;

/**
 * @author wuxiaopeng
 * @description:lamdba表达式,一个方法，接口类。 一个：只有一个抽象方法，多了不行，少了也不行。同时，
 * 这个抽象方法一定不能跟Object类中的方法同名。
 * <p>
 * 加上@FunctionalInterface注解之后，
 * 让编译器取做一个显示检查是否这个接口只含有一个抽象方法。这样的接口是一个错误的接口示例。
 * @date 2020/5/18 9:29
 */
@FunctionalInterface
public interface MyFunctionInterface<T> {
    String doSome(T t, String s);
}
