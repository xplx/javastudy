package pers.wxp.pattern.proxyI.staticProxy;

/**
 * 在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。
 * 这种类型的设计模式属于结构型模式。
 * 代理(Proxy)是一种设计模式,提供了对目标对象另外的访问方式;即通过代理对象访问目标对象.
 * 这样做的好处是:可以在目标对象实现的基础上,增强额外的功能操作,即扩展目标对象的功能.
 * 这里使用到编程中的一个思想:不要随意去修改别人已经写好的代码或者方法,如果需改修改,可以通过代理的方式来扩展该方法
 * @author wuxiaopeng
 * @date 2020/3/20 10:10
 */
public class Client1 {
    public static void main(String[] args) {
        //我们创建具有现有对象的对象，以便向外界提供功能接口。
        Image image = new ProxyImage("test.png");

        //图像将从磁盘加载
        image.display();
        System.out.println("");

        //图像将无法从磁盘加载
        image.display();
    }
}
