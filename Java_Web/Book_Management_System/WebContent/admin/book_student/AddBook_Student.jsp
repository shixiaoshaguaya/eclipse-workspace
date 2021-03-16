<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>借阅</title>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" scope="page" />
	<form id="userAction_save_do" name="Forml"
		action="${pageContext.request.contextPath }/AddBook_StudentServlet"
		method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afdlf3" colSpan="4"
					height="26"><strong><STRONG>借阅</STRONG></strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">图书编号：</td>
				<td bgColor="#ffffff"><input type="text" name="b_id"></td>
				<td align="center" bgColor="#f5fafe">学号：</td>
				<td bgColor="#ffffff"><input type="text" name="s_id"></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">借阅日期：</td>
				<td bgColor="#ffffff"><input type="date" name="borrow_date"
					value="<fmt:formatDate value='${now}' pattern='yyyy-MM-dd'/>"></td>
			</tr>
			<tr>
				<td style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<input type="submit" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<INPUT type="button" onclick="history.go(-1)" value="返回"> <span
					id="Labell"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>