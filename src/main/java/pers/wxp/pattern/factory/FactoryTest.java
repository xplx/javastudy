package pers.wxp.pattern.factory;

/**
* @author wxp
* @date 2018年1月31日 上午10:33:47
* @Description: TODO(这里用一句话描述这个类的作用)
*/
public class FactoryTest {
	public static void main(String[] args) {
		// 获得工厂类的实例
		Factory factory = Factory.getFactory();
		// 调用获得接口对象的方法，获得接口对象
		InterfaceTest inter = factory.getInterface("pers.wxp.type.Factory.TestOne");
		// 调用接口定义的方法
		inter.getName();

	}
}
