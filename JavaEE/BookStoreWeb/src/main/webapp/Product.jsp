<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	产品列表页面
	<ol>
		<c:forEach items="${products}" var="product">
			<li>${product.name}-${product.price}</li>
		</c:forEach>
	</ol>
</body>
</html>