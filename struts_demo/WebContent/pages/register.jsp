<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>欢迎注册</h3>  
    <form action="<%=path %>/Register.do" method="post">  
        用户名： <input type="text" name="user.username" >   <p/>  
        密码： <input type="password" name="user.password" > <p/>  
        <input type="submit" value="注册" />  
    </form>  
</body>
</html>