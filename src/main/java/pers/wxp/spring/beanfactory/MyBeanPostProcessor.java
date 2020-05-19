package pers.wxp.spring.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {		
		if(beanName.equals("car")){
			Car car = (Car)bean;
			if(car.getMaxSpeed() >= 200){
				System.out.println("初始化化后处理------调用MyBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。");
				car.setMaxSpeed(200);
			}
		}
		return bean;

	}
	/* (non-Javadoc)
	 * @bean：当前出路的bean。
	 * @beanName：当前bean的配置名
	 * @return:返回加工后的bean。
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {		
		if(beanName.equals("car")){
			Car car = (Car)bean;
			if(car.getColor() == null){
				System.out.println("初始化前处理------调用MyBeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色。");
				car.setColor("黑色");
			}
		}
		return bean;
	}
}
