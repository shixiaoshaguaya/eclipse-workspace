<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示在线用户数</title>
</head>
<body>
使用JSP显示当前在线人数：<%=application.getAttribute("userCounts") %>人
<br>
使用EL显示当前在线人数：${applicationScope.userCounts}人<br>
使用EL显示当前在线人数：${userCounts}人
</body>
</html>