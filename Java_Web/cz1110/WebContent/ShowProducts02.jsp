<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用EL和JSTL技术显示产品信息</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty products}">
			产品数据未初始化，请先访问
			<a heref="${pageContext.request.contextPath}/InitDataServlet">数据初始化页面</a>！
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<td>产品编号</td>
					<td>产品名称</td>
					<td>价格</td>
					<td>库存</td>
					<td>生产日期</td>
					<td>备注</td>
				</tr>
				<c:forEach var="item" items="${products}">
					<tr>
						<td>${item.value.id}</td>
						<td>${item.value.title}</td>
						<td>${item.value.price}</td>
						<td>${item.value.stock}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${item.value.manufacture}" /></td>
						<td><c:if test="${item.value.stock<10}">库存紧张，请尽快下单！</c:if>
							<c:if test="${item.value.stock>=10}">库存充足，尽管甩单！</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>