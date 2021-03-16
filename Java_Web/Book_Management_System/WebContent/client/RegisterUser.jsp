<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>

</head>
<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/AddUser"
		method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="2"
					height="26"><strong><STRONG>注册新用户</STRONG> </strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">学号：</td>
				<td bgColor="#ffffff"><input type="text" name="s_id" /><span
					id="userNameSpan" class="span1"></span></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">用户密码：</td>
				<td bgColor="#ffffff"><input type="password" name="s_password" /><span
					id="pswSpan" class="span1"></span></td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe">姓名：</td>
				<td bgColor="#ffffff"><input type="text" name="s_name" /><span
					id="surePswSpan" class="span1"></span></td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe">性别：</td>
				<td bgColor="#ffffff"><input type="text" name="sex" /><span
					id="surePswSpan" class="span1"></span></td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe">电话：</td>
				<td bgColor="#ffffff"><input type="text" name="telephone" /><span
					id="surePswSpan" class="span1"></span></td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe">已借书数量：</td>
				<td bgColor="#ffffff"><input type="text" name="s_number" /><span
					id="surePswSpan" class="span1"></span></td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe">欠款金额：</td>
				<td bgColor="#ffffff"><input type="text" name="s_money" /><span
					id="surePswSpan" class="span1"></span></td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe">创建日期：</td>
				<td bgColor="#ffffff"><input type="date" name="s_date" /><span
					id="surePswSpan" class="span1"></span></td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe">身份：</td>
				<td bgColor="#ffffff"><input type="text" name="s_identity" /><span
					id="surePswSpan" class="span1"></span></td>
			</tr>
			
			<tr>
				<td style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="2">
					<input type="submit" value="确定" > <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <input
					type="reset" value="重置"> <FONT face="宋体">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </FONT> <INPUT type="button"
					onclick="history.go(-1)" value="返回" /> <span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
