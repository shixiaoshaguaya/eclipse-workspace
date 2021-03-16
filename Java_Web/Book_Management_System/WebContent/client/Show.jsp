<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

	<a
		href="${pageContext.request.contextPath}/DeleteUser?s_id=${student.s_id}"
		onclick="return del()">注销用户</a>
	<a
		href="${pageContext.request.contextPath}/EditUser?s_id=${student.s_id}">修改个人信息</a>
	<a
		href="${pageContext.request.contextPath}/client/Query.jsp">编号查询图书</a>
	<br>
	<c:choose>
		<c:when test="${empty applicationScope.productsFromDB2}">
图书数据未初始化，请先访问
<a href="${pageContext.request.contextPath}/GetBook">数据初始化页面</a>！
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
				<c:forEach var="item" items="${applicationScope.productsFromDB2}">
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
							href="${pageContext.request.contextPath}/EditBook?b_id=${item.b_id}">编辑</a>
					</tr>
				</c:forEach>
			</table>

			<%-- 分页 --%>




		</c:otherwise>
	</c:choose>






</body>
</html>