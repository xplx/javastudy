package pers.wxp.thread.local;

/**
 * @author wuxiaopeng
 * @description:Mybatis分页插件就是通过本地变量实现，只能使用第一个sql进行分页。
 * 1.ThreadLocal是单线程内共享资源，多线程间无法共享（即线程A访问不了线程B中ThreadLocal存放的值）；
 *
 * 2.ThreadLocal是本地变量，无法跨jvm传递；
 *
 * 3.ThreadLocal的出现可以减少通过参数来传递（使代码更加简洁，降低耦合性），
 * Hibernate中的OpenSessionInView，就始终保证当前线程只有一个在使用中的Connection（或Hibernate Session）
 * @date 2020/4/17 10:07
 */
public class Client {
    protected static final ThreadLocal<Page> LOCAL_PAGE = new ThreadLocal<Page>();

    public static void main(String[] args) {
        LOCAL_PAGE.set(new Page(1,1,1,1,1,1));
        System.out.println(LOCAL_PAGE.get());
        LOCAL_PAGE.remove();
        System.out.println(LOCAL_PAGE.get());
    }
}
