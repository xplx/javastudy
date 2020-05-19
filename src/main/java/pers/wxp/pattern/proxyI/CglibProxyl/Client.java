package pers.wxp.pattern.proxyI.CglibProxyl;

/**
 * @author wuxiaopeng
 * @description:
 * 在Spring的AOP编程中:
 * 如果加入容器的目标对象有实现接口, 用JDK代理
 * 如果目标对象没有实现接口,用Cglib代理
 * @date 2020/3/20 11:09
 */
public class Client {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}
