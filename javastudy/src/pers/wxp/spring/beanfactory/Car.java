package pers.wxp.spring.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	private String brand;
	private String color;
	private int maxSpeed;
	private String name;
	private BeanFactory beanFactory;
	private String beanName;

	public Car() {
		//用构造函数或工厂方法实例化bean
		System.out.println("调用Car()构造函数。");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("调用setBrand()设置属性。");
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public String toString() {
		return "brand:" + brand + "/color:" + color + "/maxSpeed:"+ maxSpeed;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public void introduce(){
		System.out.println("introduce:"+this.toString());
	}
	

	// BeanFactoryAware接口方法（将beanFactory容器实例设置到这里面）
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用BeanFactoryAware.setBeanFactory()。beanFactory："+beanFactory);
		this.beanFactory = beanFactory;
	}

	// 如果bean实现setBeanName方法，则将配置文件中对应的bean设置到该bean中。BeanNameAware接口方法。
	public void setBeanName(String beanName) {
		System.out.println("调用BeanNameAware.setBeanName()。beanName:"+beanName);
		this.beanName = beanName;
	}

	// InitializingBean接口方法
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用InitializingBean.afterPropertiesSet()。");
	}

	// DisposableBean接口方法
	public void destroy() throws Exception {
		System.out.println("调用DisposableBean.destory()。");
	}
	//初始化
	public void myInit() {		
		System.out.println("调用myInit()，将maxSpeed设置为240。");
		this.maxSpeed = 240;
	}

	public void myDestory() {
		System.out.println("调用myDestroy()。");
	}
	
}
