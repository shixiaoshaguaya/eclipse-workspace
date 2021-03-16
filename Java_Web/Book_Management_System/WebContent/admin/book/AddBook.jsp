<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加新书籍</title>
</head>
<body>
	<form id="userAction_save_do" name="Forml"
		action="${pageContext.request.contextPath }/AddBookServlet"
		method="post" enctype="multipart/form-data">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afdlf3" colSpan="4"
					height="26"><strong><STRONG>添加书籍</STRONG></strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">图书编号：</td>
				<td bgColor="#ffffff"><input type="text" name="b_id"></td>
				<td align="center" bgColor="#f5fafe">书名：</td>
				<td bgColor="#ffffff"><input type="text" name="b_name"></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">作者：</td>
				<td bgColor="#ffffff"><input type="text" name="writer"></td>
				<td align="center" bgColor="#f5fafe">类别ID：</td>
				<td bgColor="#ffffff"><input type="text" name="sort_id"></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">单价：</td>
				<td bgColor="#ffffff"><input type="text" name="price"></td>
				<td align="center" bgColor="#f5fafe">总数量：</td>
				<td bgColor="#ffffff"><input type="text" name="total_number"></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">产品图片</td>
				<td bgColor="#ffffff" colspan="3">
					<input type="file" name="picture">
				</td>
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