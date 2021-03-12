package pers.wxp.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import pers.wxp.spring.beanfactory.Car;

@Component
public class Boss {

	private Car car;

	/**
	 * 1、先调用Boss实例化
	 */
	public Boss() {
		System.out.println("construct...");
	}

//	 @Autowired
//	 private void setCar(Car car){
//	 System.out.println("execute in setCar");
//	 this.car = car;
//	 }

	/** 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param: @param car    
	* @return void  
	* 2、执行注入   
	*/
	@Resource
	private void setCar(Car car) {
		System.out.println("execute in setCar");
		this.car = car;
	}

	//执行容器启动时初始化
	@PostConstruct
	private void init1() {
		System.out.println("execute in init1");
	}

	@PostConstruct
	private void init2() {
		System.out.println("execute in init1");
	}

	@PreDestroy
	private void destory1() {
		System.out.println("execute in destory1");
	}

	@PreDestroy
	private void destory2() {
		System.out.println("execute in destory2");
	}

}
