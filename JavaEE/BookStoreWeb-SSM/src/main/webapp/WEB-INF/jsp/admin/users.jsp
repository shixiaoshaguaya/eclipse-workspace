<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>黎明书城管理</title>
<!-- 引入css样式文件 -->
<!-- Bootstrap Core CSS -->
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div id="wrapper">
		<!-- 列表查询部分  start-->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">产品管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" method="post"
						action="${pageContext.request.contextPath  }/user/list.action">
						<div class="form-group">
							<label for="productName">产品名称</label> <input type="text"
								class="form-control" id="name" value="${user.username }"
								name="name" />
						</div>
						<div class="form-group">
							<label for="productFrom">产品类别</label> <select
								class="form-control" id="productFrom" name="category.name">
								<option value="">--请选择--</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">查询</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">产品信息列表</div>
						<!-- /.panel-heading -->
						<table class="table  table-bordered table-striped">
							<thead>
								<tr>
									<th>用户编号</th>
									<th>用户姓名</th>
									<th>用户密码</th>
									<th>用户性别</th>
									<th>用户邮箱</th>
									<th>用户联系电话</th>
									<th>用户介绍</th>
									<th>激活码</th>
									<th>用户状态</th>
									<th>用户角色</th>
									<th>注册时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="row">
									<tr>
										<td>${row.id}</td>
										<td>${row.username}</td>
										<td>${row.password}</td>
										<td>${row.gender}</td>
										<td>${row.email}</td>
										<td>${row.telephone}</td>
										<td>${row.introduce}</td>
										<td>${row.activeCode}</td>
										<td>${row.state}</td>
										<td>${row.role}</td>
										<td><fmt:formatDate value="${row.registTime}"
												pattern="yyyy-MM-dd" /></td>
										<td><a href="<%=basePath%>/jsp"
											class="btn btn-primary btn-xs"> 修改</a> <a
											href="${pageContext.request.contextPath}/product/delete.action">删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- 列表查询部分  end-->
	</div>
</body>
</html>