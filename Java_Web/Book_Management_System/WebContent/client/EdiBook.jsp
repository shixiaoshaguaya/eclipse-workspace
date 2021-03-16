<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" context="text/html;  charset=UTF-8">
<title>编辑产品</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date" scope="page" />
<form id="productAction_edit_do" name="Form1"
		action="${pageContext.request.contextPath }/EditBook" method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border"1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG></strong>
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
			<tr>
				<td style="WIDTH:100%" align="center" bgColor="f5fafe" colSpan="4">
				<input type="submit" value="确定">
				<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
				<input type="reset" value="清空">
				<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
				<INPUT type="button" onclick="history.go(-1)" value="返回">
				<span id="Labell"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>