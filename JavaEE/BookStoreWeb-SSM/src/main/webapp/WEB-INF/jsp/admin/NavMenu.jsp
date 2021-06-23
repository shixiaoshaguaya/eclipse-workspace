<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 导航侧栏 -->
	<aside class="main-sidebar">
		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">
			<!-- Sidebar user panel -->
			<div class="user-panel">
				<div class="pull-left image">
					<img src="../img/user2-160x160.jpg" class="img-circle"
						alt="User Image">
				</div>
				<div class="pull-left info">
					<p>${USER_SESSION.username}</p>
					<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
				</div>
			</div>
			<!-- search form -->
			<!--<form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="搜索...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>-->
			<!-- /.search form -->


			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu">
				<li class="header">菜单</li>

				<li id="admin-index"><a href="all-admin-index.html"><i
						class="fa fa-dashboard"></i> <span>首页</span></a></li>

				<!-- 菜单 -->
				<li class="treeview"><a href="${pageContext.request.contextPath}/product/list.action"> <i class="fa fa-cube"></i>
						<span>产品管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">

						<li id="product-list"><a
							href="${pageContext.request.contextPath}/product/list.action">
								<i class="fa fa-circle-o"></i> 全部产品
						</a></li>
						<li id="product-insert"><a
							href="${pageContext.request.contextPath}/product/insert.action"> <i
								class="fa fa-circle-o"></i> 上架产品
						</a></li>
					</ul></li>

				<li class="treeview"><a href="${pageContext.request.contextPath}/order/list.action"> <i class="fa fa-cube"></i>
						<span>订单管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">

						<li id="order-list"><a
							href="${pageContext.request.contextPath}/order/list.action">
								<i class="fa fa-circle-o"></i> 全部订单
						</a></li>
					</ul></li>

				<li class="treeview"><a href="${pageContext.request.contextPath}/user/list.action"> <i class="fa fa-cube"></i>
						<span>用户管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">

						<li id="user-list"><a
							href="${pageContext.request.contextPath}/user/list.action"> <i
								class="fa fa-circle-o"></i> 全部用户
						</a></li>

						<li id="user-insert"><a
							href="${pageContext.request.contextPath}/user/insert.action"> <i
								class="fa fa-circle-o"></i> 用户新增
						</a></li>
					</ul></li>
					
				<li class="treeview"><a href="${pageContext.request.contextPath}/analyse/anlsOrderByCatg.action"> <i class="fa fa-cube"></i>
						<span>ChartJS</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a></li>
			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>
	<!-- 导航侧栏 /-->
</body>
</html>