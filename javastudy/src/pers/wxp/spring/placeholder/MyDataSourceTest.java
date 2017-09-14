package pers.wxp.spring.placeholder;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
* @author wxp  
* @date 2017年9月14日 下午1:43:14 
* @Description: TODO(通过注解的方式获取配置属性) 
*/
@Component
public class MyDataSourceTest {
	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String userName;

	@Value("${jdbc.password}")
	private String password;

	public String toString() {
		System.out.println(userName);
		return ToStringBuilder.reflectionToString(this);
	}

	public static void main(String[] args) throws SQLException {
	
		String resourceFile = "spring/placeholder/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
		//获取配置文件属性
		String FtpUser = FileDomain.instance.getName();
		//通过注解获取配置属性
		System.out.println(ctx.getBean(MyDataSourceTest.class));
		
		//通过xml文件获取配置属性
		DataSource ds = ctx.getBean(DataSource.class);		
		Connection conn = ds.getConnection();// 连接数据库
		System.out.println(conn);
		System.out.println(ctx.getBean(MyDataSourceTest.class));
	}
}
