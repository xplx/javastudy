package pers.wxp.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* @author wxp  
* @date 2017年9月13日 下午3:02:41 
* @Description: TODO(测试Spring启动和摧毁时启动对应的程序) 
*/
public class SimpleTest {

    public static void main(String[] args) throws Throwable {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans.xml");
//        LogonService logonService = ctx.getBean(LogonService.class);
//        Assert.notNull(logonService);
//        logonService.saveLog();
//        Assert.notNull(logonService);
        //LogonController controller = ctx.getBean(LogonController.class);
        /* Car car1 = ctx.getBean(Car.class);
	     Car car2 = ctx.getBean(Car.class);
	     System.out.println(car1 != car2);*/

        ((ClassPathXmlApplicationContext)ctx).destroy();
        //Thread.currentThread().sleep(10);
    }
}
