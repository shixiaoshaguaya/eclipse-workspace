<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息详细</title>
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
		<c:otherwise>
			<table border="1">
				<tr>
					<td>学号：</td>
					<td>姓名：</td>
					<td>性别：</td>
					<td>电话：</td>
					<td>已借书数量：</td>
					<td>添加时间：</td>
					<td>操作</td>
				</tr>
				<c:forEach var="item" items="${requestScope.studentsFromDB.rows}">
					<tr>
						<td>${item.s_id}</td>
						<td>${item.s_name}</td>
						<td>${item.sex}</td>
						<td>${item.telephone}</td>
						<td>${item.s_number}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${item.s_date}" /></td>
						<td><a
							href="${pageContext.request.contextPath}/EditStudentServlet?s_id=${item.s_id}">编辑</a>
							<a
							href="${pageContext.request.contextPath}/DeleteStudentServlet?s_id=${item.s_id}"
							onclick="return del()">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<%-- 构建分页导航 --%>
		共有${requestScope.studentsFromDB.total}个产品，共${requestScope.studentsFromDB.pageTotal}页，
		当前为${requestScope.studentsFromDB.page}页
		<br>
			<c:if test="${requestScope.studentsFromDB.page!=1}">
				<a
					href="${pageContext.request.contextPath}/GetStudentServlet?pageIndex=1&pageSize=2">首页</a>
			</c:if>
			<%--如果当前页为第一页是，就没有上一页这个超链接显示 --%>
			<c:if test="${requestScope.studentsFromDB.page>1}">
				<a
					href="${pageContext.request.contextPath}/GetStudentServlet?pageIndex=${requestScope.studentsFromDB.page-1}&pageSize=2">上一页</a>
			</c:if>
			<c:forEach begin="${requestScope.studentsFromDB.start}"
				end="${requestScope.studentsFromDB.end}" step="1" var="i">
				<c:if test="${requestScope.studentsFromDB.page == i}">${i}</c:if>
				<c:if test="${requestScope.studentsFromDB.page != i}">
					<a
						href="${pageContext.request.contextPath}/GetStudentServlet?pageIndex=${i}&pageSize=2">${i}</a>
				</c:if>
			</c:forEach>
			<c:if
				test="${requestScope.studentsFromDB.page < requestScope.studentsFromDB.pageTotal}">
				<a
					href="${pageContext.request.contextPath}/GetStudentServlet?pageIndex=${requestScope.studentsFromDB.page+1}&pageSize=2">下一页</a>
			</c:if>
			<%--尾页--%>
			<c:if
				test="${requestScope.studentsFromDB.page < requestScope.studentsFromDB.pageTotal}">
				<a
					href="${pageContext.request.contextPath}/GetStudentServlet?pageIndex=${requestScope.studentsFromDB.pageTotal}&pageSize=2">尾页</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>