<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示借阅信息</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty requestScope.book_studentsFromDB}">
		借阅数据未初始化，请先访问
		<a href="${pageContext.request.contextPath}/GetBook_StudentServlet">数据初始化页面</a>！
 	</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<td>ID号</td>
					<td>图书编号</td>
					<td>学号</td>
					<td>借书日期</td>
					<td>还书日期</td>
					<td>实际还书日期</td>
					<td>续借</td>
					<td>超期罚款</td>
					<td>操作</td>
				</tr>
				<c:forEach var="item"
					items="${requestScope.book_studentsFromDB.rows}">
					<tr>
						<td>${item.id}</td>
						<td>${item.b_id}</td>
						<td>${item.s_id}</td>
						<td>${item.borrow_date}</td>
						<td>${item.return_date}</td>
						<td>${item.practical_date}</td>
						<td>${item.renew}</td>
						<td>${item.money}</td>
						<td><a
							href="${pageContext.request.contextPath}/EditBook_StudentServlet?id=${item.id}">归还</a>
							<a
							href="${pageContext.request.contextPath}/EditBook_StudentServlet2?id=${item.id}">续借</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<%-- 构建分页导航 --%>
		共有${requestScope.book_studentsFromDB.total}个产品，共${requestScope.book_studentsFromDB.pageTotal}页，
		当前为${requestScope.book_studentsFromDB.page}页
		<br>
			<c:if test="${requestScope.book_studentsFromDB.page!=1}">
				<a
					href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=1&pageSize=2">首页</a>
			</c:if>
			<%--如果当前页为第一页是，就没有上一页这个超链接显示 --%>
			<c:if test="${requestScope.book_studentsFromDB.page>1}">
				<a
					href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=${requestScope.book_studentsFromDB.page-1}&pageSize=2">上一页</a>
			</c:if>
			<c:forEach begin="${requestScope.book_studentsFromDB.start}"
				end="${requestScope.book_studentsFromDB.end}" step="1" var="i">
				<c:if test="${requestScope.book_studentsFromDB.page == i}">${i}</c:if>
				<c:if test="${requestScope.book_studentsFromDB.page != i}">
					<a
						href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=${i}&pageSize=2">${i}</a>
				</c:if>
			</c:forEach>
			<c:if
				test="${requestScope.book_studentsFromDB.page < requestScope.book_studentsFromDB.pageTotal}">
				<a
					href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=${requestScope.book_studentsFromDB.page+1}&pageSize=2">下一页</a>
			</c:if>
			<%--尾页--%>
			<c:if
				test="${requestScope.book_studentsFromDB.page < requestScope.book_studentsFromDB.pageTotal}">
				<a
					href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=${requestScope.book_studentsFromDB.pageTotal}&pageSize=2">尾页</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>