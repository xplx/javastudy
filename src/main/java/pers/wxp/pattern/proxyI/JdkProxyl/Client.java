package pers.wxp.pattern.proxyI.JdkProxyl;

import pers.wxp.pattern.proxyI.staticProxy.IUserDao;
import pers.wxp.pattern.proxyI.staticProxy.UserDaoImpl;

/**
 * @author wuxiaopeng
 * @description:
 * 1.代理对象,不需要实现接口
 * 2.代理对象的生成, 是利用JDK的API, 动态的在内存中构建代理对象(需要我们指定创建代理对象 / 目标对象实现的接口的类型)
 * 3.动态代理也叫做:JDK代理,接口代理
 *
 * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 * @date 2020/3/20 10:52
 */
public class Client {
    public static void main(String[] args) {
        // 目标对象一定需要实现接口
        IUserDao target = new UserDaoImpl();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法【代理对象】
        proxy.save();
    }
}
