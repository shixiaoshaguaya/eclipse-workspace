<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加</title>
<script type="text/javascript" language="javascript">
	var allforms = document.forms;

	function check() {

		//单击一次提交  调用函数之前先清掉上一次的检查信息。
		userNameSpan.innerText = "";
		pswSpan.innerText = "";
		surePswSpan.innerText = "";
		//用户名 检查
		var len = allforms[0].s_id.value.length;
		if (len == 15) {
			userNameSpan.innerText = "学号应该是15位";
			return false;
		}
		//密码检查
		len = allforms[0].s_password.value.length;
		if (len < 6) {
			pswSpan.innerText = "密码位数最少6位";
			return false;
		} else {
			if (allforms[0].s_password.value != allforms[0].repassword.value) {
				surePswSpan.innerText = "两次密码输入的不一致";
				return false;
			}
		}
		return true;
	}
</script>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" scope="page" />
	<form id="userAction_save_do" name="Forml"
		action="${pageContext.request.contextPath }/AddStudentServlet"
		method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afdlf3" colSpan="4"
					height="26"><strong><STRONG>添加学生</STRONG></strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">学号：</td>
				<td bgColor="#ffffff"><input type="text" name="s_id"></td>
				<td align="center" bgColor="#f5fafe">姓名：</td>
				<td bgColor="#ffffff"><input type="text" name="s_name"></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">密码：</td>
				<td bgColor="#ffffff"><input type="password" name="s_password"></td>
				<td align="center" bgColor="#f5fafe">确认密码：</td>
				<td bgColor="#ffffff"><input type="password" name="repassword"></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">性别：</td>
				<td bgColor="#ffffff"><input type="radio" name="sex" value="男"
					checked="checked" />男 <input type="radio" name="sex" value="女" />女</td>
				<td align="center" bgColor="#f5fafe">电话：</td>
				<td bgColor="#ffffff"><input type="text" name="telephone"></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">添加时间：</td>
				<td bgColor="#ffffff"><input type="date" name="s_date"
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