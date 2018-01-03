package pers.wxp.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcDemo {
	// 定义Oracle的数据库驱动程序
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	// 定义Oracle数据库的连接地址
	public static final String DBURL = "jdbc:oracle:thin:@ localhost:1521:orcl";
	// Oracle数据库的连接用户名
	public static final String DBUSER = "mytest";
	// Oracle数据库的连接密码
	public static final String DBPASS = "wxp123";

	public static void main(String[] args) throws Exception {
		Connection conn = null; // 数据库连接
		CallableStatement cstmt = null; // 数据库操作
		//String sql = "{CALL mldn_proc(?,?,?)}"; // 调用过程
		String sql = "{CALL get_emp_info_proc( ?, ? )}"; // 调用过程
		Class.forName(DBDRIVER); // 加载驱动程序
		// 连接MySQL数据库时，要写上连接的用户名和密码
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		cstmt = conn.prepareCall(sql); // 实例化对象
		cstmt.setInt(1, 1234); // 设置第一个参数是80
		cstmt.registerOutParameter(2, Types.FLOAT); // 设置返回值类型
		//cstmt.registerOutParameter(3, Types.CHAR); // 设置返回值类型
		cstmt.execute(); // 执行存储过程
		System.out.println("INOUT的返回值：" + cstmt.getInt(2));
		//System.out.println("OUT的返回值：" + cstmt.getInt(3));
		cstmt.close(); // 操作关闭
		conn.close(); // 数据库关闭
	}
}
