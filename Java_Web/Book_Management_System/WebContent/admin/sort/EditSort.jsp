<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑类别</title>
</head>
<body>
	<form id="userAction_save_do" name="Forml"
		action="${pageContext.request.contextPath }/EditSortServlet"
		method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afdlf3" colSpan="4"
					height="26"><strong><STRONG>编辑类别</STRONG></strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">类别ID：</td>
				<td bgColor="#ffffff"><input type="hidden" name="sort_id" value="${requestScope.sort.sort_id}">${requestScope.sort.sort_id}</td>
				<td align="center" bgColor="#f5fafe">类别名：</td>
				<td bgColor="#ffffff"><input type="text" name="sort_name"
					value="${requestScope.sort.sort_name}"></td>
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