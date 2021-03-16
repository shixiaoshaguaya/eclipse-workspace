<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	margin: 0px;
}
</style>
<script type="text/javascript">
	//删除商品
	function p_del() {
		var msg = "您确定要删除该商品吗？";
		if (confirm(msg) == true) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<form id="userAction_save_do" name="Forml"
		action="${pageContext.request.contextPath }/FindStudentServlet"
		method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afdlf3" colSpan="4"
					height="26"><strong><STRONG>查 询</STRONG></strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">学号：</td>
				<td bgColor="#ffffff"><input type="text" name="s_id"></td>
				<td align="center" bgColor="#f5fafe">名字：</td>
				<td bgColor="#ffffff"><input type="text" name="s_name"></td>
			</tr>
			<tr>
				<td style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<input type="submit" value="查询"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
				</td>
			</tr>
		</table>
		<c:if test="${requestScope.studentsFromDB!=null}">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center"
				bgColor="#f5fafe" border="0">
				<tr>
					<td align="center" bgColor="#afd1f3"><strong>书 籍 列 表</strong></TD>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="10%">学号</td>
								<td align="center" width="10%">姓名</td>
								<td align="center" width="9%">性别</td>
								<td align="center" width="9%">电话</td>
								<td align="center" width="8%">已借书数量</td>
								<td align="center" width="8%">添加时间</td>
								<td align="center" width="8%">编辑</td>
								<td align="center" width="8%">删除</td>
							</tr>
							<!--  循环输出所有商品 -->
							<c:forEach items="${requestScope.studentsFromDB}" var="item">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10">${item.s_id}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${item.s_name}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${item.sex}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${item.telephone}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${item.s_number}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${item.s_date}</td>
									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="${pageContext.request.contextPath}/EditStudentServlet?s_id=${item.s_id}">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</a></td>
									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="${pageContext.request.contextPath}/DeleteStudentServlet?s_id=${item.s_id}"
										onclick="javascript:return p_del()"> <img
											src="${pageContext.request.contextPath}/admin/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</table>
		</c:if>
	</form>
</body>
</html>