package pers.wxp.file;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

/** 
* @author wxp  
* @date 2017年9月13日 上午10:23:04 
* @Description: TODO(资源加载系统，对加载资源进行特殊的编码格式) 
*/
public class EncodedResourceExample {

	  public static void main(String[] args) throws Throwable  {
		  Resource res = new ClassPathResource("file1.txt");
		  //使用UTF-8的格式
		  EncodedResource encRes = new EncodedResource(res,"UTF-8");
		  String content  = FileCopyUtils.copyToString(encRes.getReader());
		  System.out.println(content);  
	}

}
