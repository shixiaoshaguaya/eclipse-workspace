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
		action="${pageContext.request.contextPath }/EditUser" method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border"1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG></strong>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">学号:</td>
				<td bgColor="#ffffff"><input type="text" name="s_id" value="${requestScope.student.s_id}"/></td>
				<td align="center" bgColor="#f5fafe">姓名:</td>
				<td bgColor="#ffffff"><input type="text" name="s_name" value="${requestScope.student.s_name}"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">密码:</td>
				<td bgColor="#ffffff"><input type="text" name="s_password" value="${requestScope.student.s_password}"/></td>
				<td align="center" bgColor="#f5fafe">性别:</td>
				<td bgColor="#ffffff"><input type="text" name="sex" value="${requestScope.student.sex }"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">电话:</td>
				<td bgColor="#ffffff"><input type="text" name="telephone" value="${requestScope.student.telephone}"/></td>
				<td align="center" bgColor="#f5fafe">已借书数量:</td>
				<td bgColor="#ffffff"><input type="text" name="s_number" value="${requestScope.student.s_number}"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">欠款金额:</td>
				<td bgColor="#ffffff"><input type="text" name="s_money" value="${requestScope.student.s_money}"/></td>
				<td align="center" bgColor="#f5fafe">创建日期:</td>
				<td bgColor="#ffffff"><input type="text" name="s_date" value="${requestScope.student.s_date }"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">身份:</td>
				<td bgColor="#ffffff"><input type="text" name="s_identity" value="${requestScope.student.s_identity}"/></td>
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