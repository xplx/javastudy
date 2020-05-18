package pers.wxp.pattern.proxyI.invocation;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/17 9:35
 */
public class Teacher implements People {
    @Override
    public String work() {
        System.out.println("老师教书育人...");
        return "教书";
    }
}
