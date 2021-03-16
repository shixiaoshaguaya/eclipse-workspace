<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>使用EL和JSTL技术显示产品信息</title>
<script type="text/javascript">
function del() {
	if(!confirm("确定要删除?")){
		window.event.returnValue = false;
	}
}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${empty applicationScope.productsFromDB }">
			产品数据未初始化，请先访问
			<a href="${pageContext.request.contextPath }/GetProdServlet">数据初始化页面</a>！
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
					<td>编辑</td>
				</tr>
				<c:forEach var="item" items="${applicationScope.productsFromDB }">
					<tr>
						<td>${item.value.id }</td>
						<td>${item.value.title }</td>
						<td>${item.value.price }</td>
						<td>${item.value.stock }</td>
						<td><fmt:formatDate pattern="yyy-MM-dd HH:mm:ss" value="${item.value.manufacture }"/></td>
						<td>
							<c:if test="${item.value.stock==0}">缺货，暂时无法下单！</c:if>
							<c:if test="${item.value.stock<10 && item.value.stock>0}">库存紧张，请尽快下单！</c:if>
							<c:if test="${item.value.stock>=10}">库存充足，尽管甩单！</c:if>
						</td>
						<td>
						<a href="${pageContext.request.contextPath }/EditProdServlet?id=${item.value.id}">编辑</a>
						<a href="${pageContext.request.contextPath }/DeleteProdServlet?id=${item.value.id}" onclick="return del()">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<a href="${pageContext.request.contextPath}/AddProduct.jsp">增加产品</a>
</body>
</html>