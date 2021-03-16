<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<form action="${pageContext.request.contextPath}/implicit.jsp"
		name="from1" method="post">
		用户名:<input type="text" name="username" value="${param['username']}">
		<input type="submit" value="提交"> 
		<input type="reset" value="重置">
	</form>
	<br /> 您输入的用户名称为：${param["username"]} 
	其他信息：
	<table border="1">
		<tr>
			<td>\${header["accept"]}</td>
			<td>${header["accept"]}</td>
		</tr>
		<tr>
			<td>\${header["user-agent"]}</td>
			<td>${header["user-agent"]}</td>
		</tr>
	</table>
</body>
</html>