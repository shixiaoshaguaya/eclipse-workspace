<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border=1>
		<tr align="center">
			<td>用户编号</td>
			<td>用户名称</td>
			<td>密码</td>
			<td>加入时间</td>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr align="center">
				<th scope="row">${user.id}</th>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td><fmt:formatDate value="${user.registertime}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>