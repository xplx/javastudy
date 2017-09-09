package pers.wxp.statictest;

/**
 * @author wuxiaopeng
 * @date 2017年6月12日 上午10:39:28
 * @Description: TODO(如果类中的某个属希望设置成公共属性，就可以设置成static)
 * @Description: TODO(static保存在全局数据区)
 * @Description: TODO(static使用原因：1、数据共享概念。2、数据不用实例化也能使用，快捷方便)
 */
public class StaticDemo {

	public static void printf() {
		System.out.println("测试类属性");
	}

	public void staticTest() {
		while (true) {

		}
	}
}
