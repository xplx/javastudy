package pers.wxp.gather;

/**
 * @author wuxiaopeng
 * @create 2018-06-27 16:39
 * 如果key是自定义的类，就必须重写hashcode()和equals()
 **/

public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Dog))
            return false;

        if(obj == this)
            return true;

        Dog other = (Dog)obj;
        return other.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}   