<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body {
	margin: 0px;
}

h3 {
	height: 30px;
	width: 1366px;
	text-align: center;
	display: table-cell;
	vertical-align: middle;
	display: table-cell
}

div {
	background-color: #E6E6E6;
}

.top {
	float: left;
}

a {
	color: #000000;
	padding-right: 12px;
	display: block;
	width: 135px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	border-bottom: 1px dotted #ccc;
	text-decoration: none;
}

a:hover {
	background: #007cc2;
	color: #FFF;
}
</style>
</head>
<body>
	<h3>欢迎使用图书管理系统后台</h3>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="26" valign="bottom" background="./images/mis_01.jpg">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="85%" align="left">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#000000">
								<script language="JavaScript">
									tmpDate = new Date();
									date = tmpDate.getDate();
									month = tmpDate.getMonth() + 1;
									year = tmpDate.getFullYear();
									document.write(year);
									document.write("年");
									document.write(month);
									document.write("月");
									document.write(date);
									document.write("日 ");

									myArray = new Array(6);
									myArray[0] = "星期日"
									myArray[1] = "星期一"
									myArray[2] = "星期二"
									myArray[3] = "星期三"
									myArray[4] = "星期四"
									myArray[5] = "星期五"
									myArray[6] = "星期六"
									weekday = tmpDate.getDay();
									if (weekday == 0 | weekday == 6) {
										document.write(myArray[weekday])
									} else {
										document.write(myArray[weekday])
									};
								</script>
						</font>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<div>
		<table width="100%" border="0">
			<tr class="top">
				<td><a href="${pageContext.request.contextPath}/admin/sort/find.jsp"
					target="mainFrame">查询类别</a></td>
			</tr>
			<tr class="top">
				<td><a href="${pageContext.request.contextPath}/GetSortServlet"
					target="mainFrame">类别管理</a></td>
			</tr>
			<tr class="top">
				<td><a href="${pageContext.request.contextPath}/admin/book/find.jsp"
					target="mainFrame">查询书籍</a></td>
			</tr>
			<tr class="top">
				<td><a href="${pageContext.request.contextPath}/GetBookServlet"
					target="mainFrame">书籍管理</a></td>
			</tr>
			<tr class="top">
				<td><a
					href="${pageContext.request.contextPath}/admin/book_student/find.jsp"
					target="mainFrame">查询借阅</a></td>
			</tr>
			<tr class="top">
				<td><a
					href="${pageContext.request.contextPath}/GetBook_StudentServlet"
					target="mainFrame">借阅管理</a></td>
			</tr>
			<tr class="top">
				<td><a
					href="${pageContext.request.contextPath}/admin/student/find.jsp"
					target="mainFrame">查询学生</a></td>
			</tr>
			<tr class="top">
				<td><a
					href="${pageContext.request.contextPath}/GetStudentServlet"
					target="mainFrame">学生管理</a></td>
			</tr>
		</table>
	</div>
</body>
</HTML>
