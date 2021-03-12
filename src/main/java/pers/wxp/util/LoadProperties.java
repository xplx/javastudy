package pers.wxp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.Test;

/**
 * @author wxp
 * @date 2018年1月3日 上午8:52:54
 * @Description: TODO(主要用于读取Java的配置文件)
 */
public class LoadProperties {
	public static void main(String[] args) throws IOException {

		// 获取服务器路径
		Properties props = new Properties();
		InputStream in = null;
		//第一种，通过类加载器进行获取properties文件流,文件路径放置在同一路径下
		//in = LoadProperties.class.getClassLoader().getResourceAsStream("config.properties");
		//第二种，通过类进行获取properties文件流,这样获取的是相对路径，看bin目录下，使用resource/config.properties是错误的。
		 in = LoadProperties.class.getResourceAsStream("/config.properties");
		props.load(in);
		// 获取值
		String domainName = props.getProperty("domainNameAll");
		System.out.println(domainName);
	}

	/**
	 * @Description: TODO(获取系统文件)
	 * @param:
	 * @return void
	 */
	@Test
	public void getSystemFiles() {
		Properties pps = System.getProperties();
		pps.list(System.out);
	}

	/**
	 * @Description: TODO(获取配置文件)
	 * @param:
	 * @return void
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void getProperties() {
		Properties pps = new Properties();
		try {
			//注意这里需要写的是绝对路径，也就是磁盘路径
			pps.load(new FileInputStream("D:/workspace/githubCode/javastudy/resource/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Enumeration enum1 = pps.propertyNames();// 得到配置文件的名字
		while (enum1.hasMoreElements()) {
			String strKey = (String) enum1.nextElement();
			String strValue = pps.getProperty(strKey);
			System.out.println(strKey + "=" + strValue);
		}
	}
}
