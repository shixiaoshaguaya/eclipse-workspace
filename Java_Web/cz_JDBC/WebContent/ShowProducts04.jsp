<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用EL和JSTL技术显示产品信息</title>
<script type="text/javascript">
	function del() {
		if (!confirm("确认要删除？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${empty applicationScope.productsFromDB2}">
产品数据未初始化，请先访问
<a href="${pageContext.request.contextPath}/GetProdServlet">数据初始化页面</a>！
 </c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<td>产品编号</td>
					<td>产品名称</td>
					<td>价格</td>
					<td>库存</td>
					<td>产品图片</td>
					<td>生产日期</td>
					<td>备注</td>
					<td>操作</td>
				</tr>
				<c:forEach var="item" items="${applicationScope.productsFromDB2}">
					<tr>
						<td>${item.id}</td>
						<td>${item.title}</td>
						<td>${item.price}</td>
						<td>${item.stock}</td>
						<td><img src='${pageContext.request.contextPath}/${item.picturePath}'/></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${item.manufacture}" /></td>
						<td><c:if test="${item.stock==0}">缺货，暂时无法下单！</c:if> <c:if
								test="${item.stock<10 && item.stock>0}">库存紧张，请尽快下单！
</c:if> <c:if test="${item.stock>=10}">库存充足，尽管甩单！</c:if></td>
						<td><a
							href="${pageContext.request.contextPath}/EditProdServlet?id=${item.id}">编辑</a>
							<a
							href="${pageContext.request.contextPath}/DeleteProdServlet?id=${item.id}"
							onclick="return del()">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<a href="${pageContext.request.contextPath}/AddProduct.jsp">增加新产品</a>
</body>
</html>