<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="sousuo">
		<form action="${pageContext.request.contextPath}/chaxun" methed="post">
			<input type="text" id="input" autocomplete="off" name="b_id"
				title="请输入商品名"> <input type="submit" id="sousuo_kuan"
				value="搜索">
		</form>
	</div>
	<jsp:useBean id="now" class="java.util.Date" scope="page" />
<form id="productAction_edit_do" name="Form1"
		action="${pageContext.request.contextPath }/EditBook" method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border"1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>查询商品</STRONG></strong>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">图书编号:</td>
				<td bgColor="#ffffff"><input type="text" name="b_id" value="${requestScope.book.b_id}"/></td>
				<td align="center" bgColor="#f5fafe">书名:</td>
				<td bgColor="#ffffff"><input type="text" name="b_name" value="${requestScope.book.b_name }"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">作者:</td>
				<td bgColor="#ffffff"><input type="text" name="writer" value="${requestScope.book.writer }"/></td>
				<td align="center" bgColor="#f5fafe">类别ID:</td>
				<td bgColor="#ffffff"><input type="text" name="sort_id" value="${requestScope.book.sort_id }"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">单价:</td>
				<td bgColor="#ffffff"><input type="text" name="price" value="${requestScope.book.price }"/></td>
				<td align="center" bgColor="#f5fafe">总数量:</td>
				<td bgColor="#ffffff"><input type="text" name="total_number" value="${requestScope.book.total_number }"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">当前数量:</td>
				<td bgColor="#ffffff"><input type="text" name="current_number" value="${requestScope.book  .current_number }"/></td>
				<td align="center" bgColor="#f5fafe">借阅次数:</td>
				<td bgColor="#ffffff"><input type="text" name="borrow_number" value="${requestScope.book.borrow_number }"/></td>
			</tr>
		</table>
	</form>
	<INPUT type="button" onclick="history.go(-1)" value="返回">
</body>
</html>