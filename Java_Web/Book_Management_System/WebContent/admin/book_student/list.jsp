<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	margin: 0px;
}
</style>
<script type="text/javascript">
	//添加
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/book_student/AddBook_Student.jsp";
	}
</script>
</head>
<body>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tr>
			<td align="center" bgColor="#afd1f3"><strong>借 阅 列 表</strong></TD>
		</tr>
		<tr>
			<td align="right">
				<button type="button" id="add" name="add" class="button_add" onclick="addProduct()">借阅</button>
			</td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe">
				<table cellspacing="0" cellpadding="1" rules="all"
					bordercolor="gray" border="1" id="DataGrid1"
					style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
					<tr
						style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
						<td align="center" width="10%">ID号</td>
						<td align="center" width="10%">图书编号</td>
						<td align="center" width="9%">学号</td>
						<td align="center" width="9%">借书日期</td>
						<td align="center" width="8%">还书日期</td>
						<td align="center" width="8%">实际还书日期</td>
						<td align="center" width="8%">续借</td>
						<td align="center" width="8%">超期罚款</td>
						<td align="center" width="8%">归还</td>
						<td align="center" width="8%">续借</td>
					</tr>
					<!--  循环输出所有商品 -->
					<c:forEach items="${requestScope.book_studentsFromDB.rows}"
						var="item">
						<tr onmouseover="this.style.backgroundColor = 'white'"
							onmouseout="this.style.backgroundColor = '#F5FAFE';">
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10">${item.id}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${item.b_id}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.s_id}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.borrow_date}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.return_date}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.practical_date}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.renew}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.money}</td>
							<td align="center" style="HEIGHT: 22px" width="7%"><a
								href="${pageContext.request.contextPath}/EditBook_StudentServlet?id=${item.id}">
									<img
									src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
									border="0" style="CURSOR: hand">
							</a></td>
							<td align="center" style="HEIGHT: 22px" width="7%"><a
								href="${pageContext.request.contextPath}/EditBook_StudentServlet2?id=${item.id}">
									<img
									src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
									border="0" style="CURSOR: hand">
							</a></td>
						</tr>
					</c:forEach>
				</table> <%-- 构建分页导航 --%>
				共有${requestScope.book_studentsFromDB.total}个产品，共${requestScope.book_studentsFromDB.pageTotal}页，
				当前为${requestScope.book_studentsFromDB.page}页 <br> <c:if
					test="${requestScope.book_studentsFromDB.page!=1}">
					<a
						href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=1&pageSize=2">首页</a>
				</c:if> <%--如果当前页为第一页是，就没有上一页这个超链接显示 --%> <c:if
					test="${requestScope.book_studentsFromDB.page>1}">
					<a
						href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=${requestScope.book_studentsFromDB.page-1}&pageSize=2">上一页</a>
				</c:if> <c:forEach begin="${requestScope.book_studentsFromDB.start}"
					end="${requestScope.book_studentsFromDB.end}" step="1" var="i">
					<c:if test="${requestScope.book_studentsFromDB.page == i}">${i}</c:if>
					<c:if test="${requestScope.book_studentsFromDB.page != i}">
						<a
							href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=${i}&pageSize=2">${i}</a>
					</c:if>
				</c:forEach> <c:if
					test="${requestScope.book_studentsFromDB.page < requestScope.book_studentsFromDB.pageTotal}">
					<a
						href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=${requestScope.book_studentsFromDB.page+1}&pageSize=2">下一页</a>
				</c:if> <%--尾页--%> <c:if
					test="${requestScope.book_studentsFromDB.page < requestScope.book_studentsFromDB.pageTotal}">
					<a
						href="${pageContext.request.contextPath}/GetBook_StudentServlet?pageIndex=${requestScope.book_studentsFromDB.pageTotal}&pageSize=2">尾页</a>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>