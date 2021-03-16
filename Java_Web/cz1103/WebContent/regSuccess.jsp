<%@page import="cz1103.javaBean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	使用JSP方式获取：您提交的注册信息如下：<br>
	<ul>
 		<li>姓名：<%=request.getAttribute("uName") %></li>
		<li>密 码：<%=request.getAttribute("uPassword") %></li>
		<li>性别:<%=request.getAttribute("uSex") %></li>
	</ul>
	<br>
	使用EL表达式获取：您提交的注册信息如下：<br>
	<ul>
 		<li>姓名：${requestScope.uName}</li>
		<li>密 码：${requestScope.uPassword}</li>
		<li>性别：${requestScope.uSex}</li>
	</ul>
	使用JSP方式获取：您提交的注册信息如下：<br>
	<% User user = (User)request.getSession().getAttribute("UserInfo"); %>
	<ul>
 		<li>姓名：<%=user.getName() %></li>
		<li>密 码：<%=user.getPassword() %></li>
		<li>性别:<%=user.getSex() %></li>
	</ul>
	<br>
	使用EL表达式获取：您提交的注册信息如下：<br>
	<ul>
 		<li>姓名：${sessionScope.UserInfo.name}</li>
		<li>密 码：${sessionScope.UserInfo.password}</li>
		<li>性别：${sessionScope.UserInfo.sex}</li>
	</ul>
</body>
</html>