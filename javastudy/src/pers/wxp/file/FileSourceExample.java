package pers.wxp.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

public class FileSourceExample {

	public static void main(String[] args) {
		try {
			String filePath = "D:/workspace/githubCode/javastudy/resource/file1.txt";
			// 可写资源的接口
			WritableResource res1 = new PathResource(filePath);
			// WritableResource接口写资源
			OutputStream stream1 = res1.getOutputStream();
			stream1.write("欢迎光临\n小春论坛今天的天气很好".getBytes());
			stream1.close();

			// 使用类路径加载
			Resource res2 = new ClassPathResource("file1.txt");
			// getInputStream获取文件的输入流
			InputStream ins1 = res1.getInputStream();
			InputStream ins2 = res2.getInputStream();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int i;
			while ((i = ins1.read()) != -1) {
				baos.write(i);
			}
			System.out.println(baos.toString());
			// 获取资源名称
			System.out.println("res1:" + res1.getFilename());
			System.out.println("res2:" + res2.getFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
