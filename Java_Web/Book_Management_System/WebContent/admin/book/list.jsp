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
		window.location.href = "${pageContext.request.contextPath}/admin/book/AddBook.jsp";
	}
	//删除
	function p_del() {
		var msg = "您确定要删除该书籍吗？";
		if (confirm(msg) == true) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tr>
			<td align="center" bgColor="#afd1f3"><strong>书 籍 列 表</strong></TD>
		</tr>
		<tr>
			<td align="right">
				<button type="button" id="add" name="add" value="&#28155;&#21152;"
					class="button_add" onclick="addProduct()">
					&#28155;&#21152;</button>
			</td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe">
				<table cellspacing="0" cellpadding="1" rules="all"
					bordercolor="gray" border="1" id="DataGrid1"
					style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
					<tr
						style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
						<td align="center" width="10%">图书编号</td>
						<td align="center" width="10%">图片</td>
						<td align="center" width="8%">书名</td>
						<td align="center" width="9%">作者</td>
						<td align="center" width="9%">类别ID</td>
						<td align="center" width="8%">单价</td>
						<td align="center" width="8%">总数量</td>
						<td align="center" width="8%">当前数量</td>
						<td align="center" width="8%">借阅次数</td>
						<td align="center" width="8%">编辑</td>
						<td align="center" width="8%">删除</td>
					</tr>
					<!--  循环输出所有商品 -->
					<c:forEach items="${requestScope.booksFromDB.rows}" var="item">
						<tr onmouseover="this.style.backgroundColor = 'white'"
							onmouseout="this.style.backgroundColor = '#F5FAFE';">
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10">${item.b_id}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10"><img
								src='${pageContext.request.contextPath}/${item.picturePath}'
								style="width: 100px; height: 60px" /></td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.b_name}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.writer}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.sort_id}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.price}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.total_number}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.current_number}</td>
							<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${item.borrow_number}</td>
							<td align="center" style="HEIGHT: 22px" width="7%"><a
								href="${pageContext.request.contextPath}/EditBookServlet?b_id=${item.b_id}">
									<img
									src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
									border="0" style="CURSOR: hand">
							</a></td>
							<td align="center" style="HEIGHT: 22px" width="7%"><a
								href="${pageContext.request.contextPath}/DeleteBookServlet?b_id=${item.b_id}"
								onclick="javascript:return p_del()"> <img
									src="${pageContext.request.contextPath}/admin/images/i_del.gif"
									width="16" height="16" border="0" style="CURSOR: hand">
							</a></td>
						</tr>
					</c:forEach>
				</table> <%-- 构建分页导航 --%>
				共有${requestScope.booksFromDB.total}个产品，共${requestScope.booksFromDB.pageTotal}页，
				当前为${requestScope.booksFromDB.page}页 <br> <c:if
					test="${requestScope.booksFromDB.page!=1}">
					<a
						href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=1&pageSize=2">首页</a>
				</c:if> <%--如果当前页为第一页是，就没有上一页这个超链接显示 --%> <c:if
					test="${requestScope.booksFromDB.page>1}">
					<a
						href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=${requestScope.booksFromDB.page-1}&pageSize=2">上一页</a>
				</c:if> <c:forEach begin="${requestScope.booksFromDB.start}"
					end="${requestScope.booksFromDB.end}" step="1" var="i">
					<c:if test="${requestScope.booksFromDB.page == i}">${i}</c:if>
					<c:if test="${requestScope.booksFromDB.page != i}">
						<a
							href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=${i}&pageSize=2">${i}</a>
					</c:if>
				</c:forEach> <c:if
					test="${requestScope.booksFromDB.page < requestScope.booksFromDB.pageTotal}">
					<a
						href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=${requestScope.booksFromDB.page+1}&pageSize=2">下一页</a>
				</c:if> <%--尾页--%> <c:if
					test="${requestScope.booksFromDB.page < requestScope.booksFromDB.pageTotal}">
					<a
						href="${pageContext.request.contextPath}/GetBookServlet?pageIndex=${requestScope.booksFromDB.pageTotal}&pageSize=2">尾页</a>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>