package pers.wxp.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

public class FileDemo {
	/**
	 * 將文件寫入
	 * @throws IOException
	 */
	@Test
	public void fileDemo1() throws IOException {
		File file1 = new java.io.File("F:\\file.txt");
		// OutputStream output = new FileOutputStream(file1);//通过子类实例化父类，覆盖的方式
		OutputStream output = new FileOutputStream(file1, true);// 通过子类实例化父类，追加的方式
		if (file1.exists()) {
			file1.delete();
		}
		try {
			file1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hString = "hello word \r\n";// 换行
		output.write(hString.getBytes());// 将数据变为字节数组输出
		output.close();
	}

	/**
	 * @throws IOException
	 *             一次读取指定长度字节数据
	 */
	@Test
	public void fileDemo2() throws IOException {
		File file1 = new java.io.File("F:\\file.txt");
		// OutputStream output = new FileOutputStream(file1);//通过子类实例化父类，覆盖的方式
		InputStream input = new FileInputStream(file1);// 通过子类实例化父类，追加的方式
		byte data[] = new byte[10];//
		int len = 0;
		while ((len = input.read(data)) != -1) {// 字节流要放在这
			System.out.println(new String(data, 0, len));
		}
		input.close();
	}

	/**
	 * @throws IOException
	 *             每次读取一个字节
	 */
	@Test
	public void fileDemo3() throws IOException {
		File file1 = new java.io.File("F:\\file.txt");
		// OutputStream output = new FileOutputStream(file1);//通过子类实例化父类，覆盖的方式
		InputStream input = new FileInputStream(file1);// 通过子类实例化父类，追加的方式
		byte data[] = new byte[1024];
		int foot = 0;
		int temp = 0;
		do {
			temp = input.read();
			if (temp != -1) {
				data[foot++] = (byte) temp;
			}
		} while (temp != -1);
			System.out.println(new String(data, 0, foot));
		input.close();
	}
}
