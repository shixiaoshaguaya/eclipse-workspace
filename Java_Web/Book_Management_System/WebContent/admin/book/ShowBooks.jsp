<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示书籍信息</title>
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
		<c:when test="${empty requestScope.booksFromDB}">
		书籍数据未初始化，请先访问
		<a href="${pageContext.request.contextPath}/GetBookServlet">数据初始化页面</a>！
 	</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<td>图书编号</td>
					<td>书名</td>
					<td>作者</td>
					<td>类别ID</td>
					<td>单价</td>
					<td>总数量</td>
					<td>当前数量</td>
					<td>借阅次数</td>
					<td>操作</td>
				</tr>
				<c:forEach var="item" items="${requestScope.booksFromDB.rows}">
					<tr>
						<td>${item.b_id}</td>
						<td>${item.b_name}</td>
						<td>${item.writer}</td>
						<td>${item.sort_id}</td>
						<td>${item.price}</td>
						<td>${item.total_number}</td>
						<td>${item.current_number}</td>
						<td>${item.borrow_number}</td>
						<td><a
							href="${pageContext.request.contextPath}/EditBookServlet?b_id=${item.b_id}">编辑</a>
							<a
							href="${pageContext.request.contextPath}/DeleteBookServlet?b_id=${item.b_id}"
							onclick="return del()">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<%-- 构建分页导航 --%>
		共有${requestScope.booksFromDB.total}个产品，共${requestScope.booksFromDB.pageTotal}页，
		当前为${requestScope.booksFromDB.page}页
		<br>
			<c:if test="${requestScope.booksFromDB.page!=1}">
				<a
					href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=1&pageSize=2">首页</a>
			</c:if>
			<%--如果当前页为第一页是，就没有上一页这个超链接显示 --%>
			<c:if test="${requestScope.booksFromDB.page>1}">
				<a
					href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=${requestScope.booksFromDB.page-1}&pageSize=2">上一页</a>
			</c:if>
			<c:forEach begin="${requestScope.booksFromDB.start}"
				end="${requestScope.booksFromDB.end}" step="1" var="i">
				<c:if test="${requestScope.booksFromDB.page == i}">${i}</c:if>
				<c:if test="${requestScope.booksFromDB.page != i}">
					<a
						href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=${i}&pageSize=2">${i}</a>
				</c:if>
			</c:forEach>
			<c:if
				test="${requestScope.booksFromDB.page < requestScope.booksFromDB.pageTotal}">
				<a
					href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=${requestScope.booksFromDB.page+1}&pageSize=2">下一页</a>
			</c:if>
			<%--尾页--%>
			<c:if
				test="${requestScope.booksFromDB.page < requestScope.booksFromDB.pageTotal}">
				<a
					href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=${requestScope.booksFromDB.pageTotal}&pageSize=2">尾页</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>