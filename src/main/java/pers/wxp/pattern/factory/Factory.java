package pers.wxp.pattern.factory;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/31 9:09
 */
public class Factory {
    public static Fruit getInstance(String ClassName) {
        Fruit f=null;
        try {
            f=(Fruit)Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
