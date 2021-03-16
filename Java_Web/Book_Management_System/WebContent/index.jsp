<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
<script type="text/javascript" language="javascript">
	var allforms = document.forms;
	function check() {
		//单击一次提交 调用函数之前先清掉上一次的检查信息。
		userNameSpan.innerText = "";
		pswSpan.innerText = "";
		surePswSpan.innerText = "";
		//用户名 检查
		var len = allforms[0].s_id.value.length;
		if (len<1 || len>20) {

			userNameSpan.innerText = "用户名应该是4-6位";

			return false;
		}
		//密码检查
		len = allforms[0].s_password.value.length;
		if (len < 0) {
			pswSpan.innerText = "密码位数最少3位";
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<a href="${pageContext.request.contextPath}/AddUser">用户注册</a>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/LoginServlet" method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="2"
					height="26"><strong><STRONG>用户登录</STRONG> </strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">用户名称：</td>
				<td bgColor="#ffffff"><input type="text" name="id" /><span
					id="userNameSpan" class="span1"></span></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">用户密码：</td>
				<td bgColor="#ffffff"><input type="password" name="password" /><span
					id="pswSpan" class="span1"></span></td>
			</tr>
			<tr>
				<td class="title">用户类型:</td>
				<td class="input"><input type="radio" name="type" value="reader" checked="checked" />&nbsp;&nbsp;读者&nbsp;&nbsp; 
				<input type="radio" name="type" value="admin" />&nbsp;&nbsp;管理员</td>
			</tr>
			<tr>
				<td style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="2">
					<input type="submit" value="确定" onclick="return check();">
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <input
					type="reset" value="重置"> <FONT face="宋体">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </FONT> <INPUT type="button"
					onclick="history.go(-1)" value="返回" /> <span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>