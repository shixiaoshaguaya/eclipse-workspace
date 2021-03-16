<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	%>
	<form action="${pageContext.request.contextPath}/RegServlet"
		name="from1" method="post">
		用户名:<input type="text" name="username"> 密 码:<input
			type="password" name="pwd"> 确认密码：<input type="password"
			name="repwd"> 性别： <input type="radio" name="sex" value="男">男
		<input type="radio" name="sex" value="女">女 <input
			type="submit" value="提交"> <input type="reset" value="重置">
	</form>
</body>
</html>