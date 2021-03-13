package pers.wxp.pattern.factory;

public class TestOne implements InterfaceTest {
	/*
	 * 根据业务，重写方法
	 */
	@Override
	public void getName() {
		// TODO Auto-generated method stub
		System.out.println("test1");
	}

}
