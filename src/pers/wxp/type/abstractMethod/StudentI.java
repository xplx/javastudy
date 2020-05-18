package pers.wxp.type.abstractMethod;

/**
 * @author wxp
 * @date 2017年10月13日 下午3:06:37
 * @Description: TODO(接口比抽象类更加抽象，因为抽象类中可以定义构造器，可以有抽象方法和具体方法，
 *               而接口中不能定义构造器而且其中的方法全部都是抽象方法。)
 */
public interface StudentI {
	int a = 10;
	/**
	 * @Description: TODO(只能有抽象的方法)
	 * @param:
	 * @return void
	 */
	public void getNmae();
}
