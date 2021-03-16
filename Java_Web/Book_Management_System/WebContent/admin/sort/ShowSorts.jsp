<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示类别信息</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty requestScope.sortsFromDB}">
		类别数据未初始化，请先访问
		<a href="${pageContext.request.contextPath}/GetSortServlet">数据初始化页面</a>！
 	</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<td>类别ID</td>
					<td>类别名</td>
					<td>操作</td>
				</tr>
				<c:forEach var="item" items="${requestScope.sortsFromDB.rows}">
					<tr>
						<td>${item.sort_id}</td>
						<td>${item.sort_name}</td>
						<td><a
							href="${pageContext.request.contextPath}/EditSortServlet?sort_id=${item.sort_id}">编辑</a>
							<a
							href="${pageContext.request.contextPath}/DeleteSortServlet?sort_id=${item.sort_id}"
							onclick="return del()">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<%-- 构建分页导航 --%>
		共有${requestScope.sortsFromDB.total}个产品，共${requestScope.sortsFromDB.pageTotal}页，
		当前为${requestScope.sortsFromDB.page}页
		<br>
			<c:if test="${requestScope.sortsFromDB.page!=1}">
				<a
					href="${pageContext.request.contextPath}/GetSortServlet?pageIndex=1&pageSize=2">首页</a>
			</c:if>
			<%--如果当前页为第一页是，就没有上一页这个超链接显示 --%>
			<c:if test="${requestScope.sortsFromDB.page>1}">
				<a
					href="${pageContext.request.contextPath}/GetSortServlet?pageIndex=${requestScope.sortsFromDB.page-1}&pageSize=2">上一页</a>
			</c:if>
			<c:forEach begin="${requestScope.sortsFromDB.start}"
				end="${requestScope.sortsFromDB.end}" step="1" var="i">
				<c:if test="${requestScope.sortsFromDB.page == i}">${i}</c:if>
				<c:if test="${requestScope.sortsFromDB.page != i}">
					<a
						href="${pageContext.request.contextPath}/GetSortServlet?pageIndex=${i}&pageSize=2">${i}</a>
				</c:if>
			</c:forEach>
			<c:if
				test="${requestScope.sortsFromDB.page < requestScope.sortsFromDB.pageTotal}">
				<a
					href="${pageContext.request.contextPath}/GetSortServlet?pageIndex=${requestScope.sortsFromDB.page+1}&pageSize=2">下一页</a>
			</c:if>
			<%--尾页--%>
			<c:if
				test="${requestScope.sortsFromDB.page < requestScope.sortsFromDB.pageTotal}">
				<a
					href="${pageContext.request.contextPath}/GetSortServlet?pageIndex=${requestScope.sortsFromDB.pageTotal}&pageSize=2">尾页</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>