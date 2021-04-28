<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="productList3">
		productList3
		<label>产品ID</label>
		<input name="productid">
		<input type="submit" value="查询">
	</form>
	<form action="productName">
		productName
		<label>产品名称</label>
		<input name="productname">
		<input type="submit" value="查询">
	</form>
	<br />
	<form action="productList4" method="post">
		productList4
		<label>产品ID</label>
		<input name="productid">
		<input type="submit" value="查询">
	</form>
	<form action="productName2" method="post">
		productName2
		<label>产品名称</label>
		<input name="productname">
		<input type="submit" value="查询">
	</form>
	<br />
	<form action="productList5" method="post">
		productList5
		<label>产品ID</label>
		<input name="productid">
		<input type="submit" value="查询">
	</form>
	<form action="productName3" method="post">
		productName3
		<label>产品名称</label>
		<input name="productname">
		<input type="submit" value="查询">
	</form>
	<table width="100%" border=1>
		<tr align="center">
			<td>产品编号</td>
			<td>产品名称</td>
			<td>类别</td>
			<td>价格</td>
			<td>图片</td>
			<td>条形码</td>
			<td>二维码</td>
			<td>说明</td>
			<td>生产时间</td>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr align="center">
				<th scope="row">${product.id}</th>
				<td>${product.productname}</td>
				<td>${product.category}</td>
				<td>${product.price}</td>
				<td>${product.image}</td>
				<td>${product.barcode}</td>
				<td>${product.qrcode}</td>
				<td>${product.description}</td>
				<td><fmt:formatDate value="${product.protime}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>