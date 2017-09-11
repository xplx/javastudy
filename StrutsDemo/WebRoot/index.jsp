<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Basic Struts 2 Application - Welcome</title>
</head>

<body>
	<h1>Welcome To Struts 2!</h1>
	<p>
		<a href="<s:url action='hello'/>">Hello World</a>
	</p>

	<form action="<%=path%>/hello" method="post">
		用户名： <input type="text" name="username">
		<p />
		密码： <input type="password" name="password">
		<p />
		<input type="submit" value="注册" />
	</form>
</body>
</html>
