package pers.wxp.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class SendXml extends HttpServlet {

	private static final Logger logger = Logger.getLogger(SendXml.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		send(Integer.parseInt(req.getParameter("n")));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	public void send(int n) throws IOException {
		try {// testPostServlet
			String result = null;
			String testServletUrl = "";
			if (n > 1) {
				System.out.println("select=====");
				testServletUrl = SendXml.testServletUrl("http://localhost:23456/LoginServer/select", getSelectInfo1());
			} else {
				System.out.println("login=====");
				testServletUrl = SendXml.testServletUrl("http://localhost:23456/LoginServer/login", getLoginInfo());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String testServletUrl(String path, String xml) throws Exception {
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");// 提交模式
		conn.setConnectTimeout(10000);// 连接超时 单位毫秒
		conn.setReadTimeout(5000);// 读取超时 单位毫秒
		conn.setDoOutput(true);// 是否输入参数
		// 通过conn.getOutputStream().write 将XML信息写入，在另一端系统，get出来再解析
		conn.getOutputStream().write(xml.getBytes("UTF-8"));
		System.out.println("发送数据：" + xml);

		if (conn.getResponseCode() == 200) {
			InputStream inStream = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
			String data;
			StringBuffer stringBuffer = new StringBuffer();
			while ((data = br.readLine()) != null) {
				stringBuffer.append(data);
			}
			String strData = stringBuffer.toString();
			System.out.println("接收数据：" + strData);
			inStream.close();
		}

		return xml;
	}

	public static String getLoginInfo() {

		String id = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
		String last = "GW.1";
		int type = 0;
		String value = ValidationHelper.getCode(1, id, last);

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<Header>");
		sb.append("	<ID>" + id + "</ID>");
		sb.append(" <Name>");
		sb.append("		<first>www. FONTUR.com</first>");
		sb.append(" 	<app>StudentCard</app>");
		sb.append("		<last>" + last + "</last>");
		sb.append("	</Name>");
		sb.append("	<Address>");
		sb.append("		<IP>220.113.61.127</IP>");
		sb.append("		<port>12345</port>");
		sb.append("	</Address>");
		sb.append("	<TTL>20161212235959</TTL>");
		sb.append("	<Check>");
		sb.append("		<type>" + type + "</type>");
		sb.append("		<value>" + value + "</value>");
		sb.append("	</Check>");
		sb.append("	<Security>");
		sb.append("		<type>1</type>");
		sb.append("		<value>0</value>");
		sb.append("	</Security>");
		sb.append("</Header>");
		return sb.toString();
	}

	public static String getSelectInfo1() {
		String id = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
		String last = "VP8500.12345678";
		int type = 0;
		String value = ValidationHelper.getCode(1, id, last);

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<Header>");
		sb.append("	<ID>" + id + "</ID>");
		sb.append("	<Name>");
		sb.append("		<first>www.salvador.com</first>");
		sb.append("		<app>BusSystem</app>");
		sb.append("		<last>" + last + "</last>");
		sb.append("	</Name>");
		sb.append("	<Check>");
		sb.append("		<type>0</type>");
		sb.append("		<value></value>");
		sb.append("	</Check>");
		sb.append("	<Request>");
		sb.append("		<Name>");
		// sb.append(" <first>www.FONTUR.com</first>");
		// sb.append(" <app>StudentCard</app>");
		// sb.append(" <last>GW</last>");
		sb.append("			<first>www.salvador.com</first>");
		sb.append("			<app>BusSystem</app>");
		sb.append("			<last>IcReceiver</last>");
		sb.append("		</Name>");
		sb.append("	</Request>");
		sb.append("</Header>");
		return sb.toString();
	}

	public static String getSelectInfo2() {
		String id = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
		String last = "VP8500.12345678";
		int type = 0;
		String value = ValidationHelper.getCode(1, id, last);

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<Header>");
		sb.append("	<ID>" + id + "</ID>");
		sb.append("	<Name>");
		sb.append("		<first>www.salvador.com</first>");
		sb.append("		<app>BusSystem</app>");
		sb.append("		<last>" + last + "</last>");
		sb.append("	</Name>");
		sb.append("	<Check>");
		sb.append("		<type>0</type>");
		sb.append("		<value></value>");
		sb.append("	</Check>");
		sb.append("	<Request>");
		sb.append("		<Name>");
		// sb.append(" <first>www.FONTUR.com</first>");
		// sb.append(" <app>StudentCard</app>");
		// sb.append(" <last>GW</last>");
		sb.append("			<first>www.salvador.com</first>");
		sb.append("			<app>BusSystem</app>");
		sb.append("			<last>IcReceiver</last>");
		sb.append("		</Name>");
		sb.append("	</Request>");
		sb.append("</Header>");
		return sb.toString();
	}

	public static String getSelectInfo3() {
		String id = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
		String last = "VP8500.12345678";
		int type = 0;
		String value = ValidationHelper.getCode(1, id, last);

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<Header>");
		sb.append("	<ID>" + id + "</ID>");
		sb.append("	<Name>");
		sb.append("		<first>www.salvador.com</first>");
		sb.append("		<app>StudentSystem</app>");
		sb.append("		<last>" + last + "</last>");
		sb.append("	</Name>");
		sb.append("	<Check>");
		sb.append("		<type>0</type>");
		sb.append("		<value></value>");
		sb.append("	</Check>");
		sb.append("	<Request>");
		sb.append("		<Name>");
		sb.append("			<first>www.salvador.com</first>");
		sb.append("			<app>BusSystem</app>");
		sb.append("			<last>IcReceiver</last>");
		sb.append("		</Name>");
		sb.append("	</Request>");
		sb.append("</Header>");
		return sb.toString();
	}

	public static void main(String[] args) {
		try {// testPostServlet
			String result = null;
			result = SendXml.testServletUrl("http://192.168.20.137:8080/LoginServer/select", getSelectInfo1());
			// result =
			// SendXml.testServletUrl("http://192.168.20.137:8080/LoginServer/select",
			// getSelectInfo2());
			// result =
			// SendXml.testServletUrl("http://192.168.20.137:8080/LoginServer/select",
			// getSelectInfo3());
			System.out.println("result:" + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Time out");
			//e.printStackTrace();
		}

		// String info = getSelectInfo();
		// System.out.println(info);

	}

}
