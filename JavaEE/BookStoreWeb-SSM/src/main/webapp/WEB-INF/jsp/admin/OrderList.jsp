<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">




    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">




    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- iCheck -->
    <!-- Morris chart -->
    <!-- jvectormap -->
    <!-- Date Picker -->
    <!-- Daterange picker -->
    <!-- Bootstrap time Picker -->
    <!--<link rel="stylesheet" href="../../../plugins/timepicker/bootstrap-timepicker.min.css">-->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--数据表格-->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- Bootstrap Color Picker -->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--bootstrap-markdown-->
    <!-- Theme style -->
    <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
    <!-- Ion Slider -->
    <!-- ion slider Nice -->
    <!-- bootstrap slider -->
    <!-- bootstrap-datetimepicker -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->








    <!-- jQuery 2.2.3 -->
    <!-- jQuery UI 1.11.4 -->
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <!-- Bootstrap 3.3.6 -->
    <!-- Morris.js charts -->
    <!-- Sparkline -->
    <!-- jvectormap -->
    <!-- jQuery Knob Chart -->
    <!-- daterangepicker -->
    <!-- datepicker -->
    <!-- Bootstrap WYSIHTML5 -->
    <!-- Slimscroll -->
    <!-- FastClick -->
    <!-- iCheck -->
    <!-- AdminLTE App -->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- bootstrap color picker -->
    <!-- bootstrap time picker -->
    <!--<script src="../../../plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
    <!-- Bootstrap WYSIHTML5 -->
    <!--bootstrap-markdown-->
    <!-- CK Editor -->
    <!-- InputMask -->
    <!-- DataTables -->
    <!-- ChartJS 1.0.1 -->
    <!-- FLOT CHARTS -->
    <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
    <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
    <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
    <!-- jQuery Knob -->
    <!-- Sparkline -->
    <!-- Morris.js charts -->
    <!-- Ion Slider -->
    <!-- Bootstrap slider -->
    <!-- bootstrap-datetimepicker -->
    <!-- 页面meta /-->

    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="../plugins/morris/morris.css">
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="../plugins/select2/select2.css">
    <link rel="stylesheet" href="../plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="../plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

    <div class="wrapper">

        <!-- 页面头部 -->
        <%@ include file="Header.jsp"%>
        <!-- 页面头部 /-->

        <!-- 导航侧栏 -->
        <%@ include file="NavMenu.jsp"%>
        <!-- 导航侧栏 /-->

        <!-- 内容区域 -->
        <div class="content-wrapper">

            <!-- 内容头部 -->
            <section class="content-header">
                <h1>
                    订单管理
                    <small>全部订单</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                    <li><a href="all-order-manage-list.html">订单管理</a></li>
                    <li class="active">全部订单</li>
                </ol>
            </section>
            <!-- 内容头部 /-->

            <!-- 正文区域 -->
            <section class="content">
                <!-- .box-body -->
                <div class="box box-primary">
					<!-- search form -->
					<div class="box-header with-border">
						<h3 class="box-title">查询</h3>
					</div>
					<form id="searchForm" class="form-inline" method="get"
						action="list.action">
						<input type="hidden" id="pageNum" name="pageNum"
							value="${pageInfo.pageNum}"> <input type="hidden"
							name="pageSize" value="${pageInfo.pageSize}">
						<div class="form-group">
							<label for="title">订单号</label> <input type="text"
								class="form-control" id="id" name="id"
								value="${orderCondition.id}" placeholder="订单号">
						</div>
						<div class="form-group">
							<label for="title">客户名称</label> <input type="text"
								class="form-control" id="title" name="user.username"
								value="${orderCondition.user.username}" placeholder="客户名称">
						</div>
						<div class="form-group">
							<label for="title">客户电话</label> <input type="text"
								class="form-control" id="title" name="user.telephone"
								value="${orderCondition.user.telephone}" placeholder="客户电话">
						</div>
						<div class="form-group">
							<label for="category">支付状态</label> <select class="form-control"
								name='payState'>
								<option value="">全部</option>
								<option value="0"
									<c:if test="${orderCondition.payState == 0}">selected</c:if>>
									未支付</option>
								<option value="1"
									<c:if test="${orderCondition.payState == 1}">selected</c:if>>
									已支付</option>
							</select>
						</div>
						<div class="form-group">
							<label for="category">订单状态</label> <select class="form-control"
								name='orderState'>
								<option value="">全部</option>
								<option value="0"
									<c:if test="${orderCondition.orderState == 0}">selected</c:if>>
									未发货</option>
								<option value="1"
									<c:if test="${orderCondition.orderState == 1}">selected</c:if>>
									已发货</option>
								<option value="2"
									<c:if test="${orderCondition.orderState == 2}">selected</c:if>>
									已签收</option>
								<option value="3"
									<c:if test="${orderCondition.orderState == 3}">selected</c:if>>
									已评价</option>
							</select>
						</div>
						<div class="form-group">
							<label for="title">起始日期</label> <input type="date"
								class="form-control" id="startDate" name="startDate"
								value="<fmt:formatDate value='${orderCondition.startDate}' pattern='yyyy-MM-dd'/>"
								placeholder="起始日期">
						</div>
						<div class="form-group">
							<label for="title">终止日期</label> <input type="date"
								class="form-control" id="endDate" name="endDate"
								value="<fmt:formatDate value='${orderCondition.endDate}' pattern='yyyy-MM-dd'/>"
								placeholder="终止日期">
						</div>
						<div class="form-group">
							<button type="submit" id="search-btn" class="btn  btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</form>
					<!-- /.search form -->
					<div class="box-header with-border">
                        <h3 class="box-title">列表</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="撤销" onclick='del();'><i class="fa fa-trash-o"></i> 撤销</button>
                                        <button type="button" class="btn btn-default" title="开启" onclick='confirm("你确认要开启吗？")'><i class="fa fa-check"></i> 开启</button>
                                        <button type="button" class="btn btn-default" title="屏蔽" onclick='confirm("你确认要屏蔽吗？")'><i class="fa fa-ban"></i> 屏蔽</button>
                                        <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                                    </div>
                                </div>
                            </div>
							<form class="form-inline" method="post"
								action="list.action">
								<div class="box-tools pull-right">
									<div class="has-feedback">
										<input type="text" class="form-control input-sm"
											placeholder="搜索" id="name" value="${product.name }"
								name="name" > <span
											class="glyphicon glyphicon-search form-control-feedback"></span>
									</div>
								</div>
							</form>
							<!--工具栏/-->

                            <!--数据列表-->
                            <table  id="dataList"
                              class="table  table-bordered table-striped table-hover  dataTable">
                              <thead>
                                 <tr>
                                     <th  class="" style="padding-right: 0px;"><input
                                         id="selall" type="checkbox"  class="icheckbox_square-blue">
                                     </th>
										<th class="sorting_asc">ID</th>
										<th class="sorting">客户姓名</th>
										<th class="sorting">客户电话</th>
										<th class="sorting">订单金额</th>
										<th class="sorting">订单日期</th>
										<th class="sorting">支付状态</th>
										<th class="sorting">订单状态</th>
										<th class="text-center">操作</th>
									</tr>
                              </thead>
                              <tbody>
                                 <c:forEach  items="${pageInfo.list}" var="row">
                                    <tr id="${row.id}">
                                        <td><input name="ids" type="checkbox" value="${row.id}"></td>
                                        <td>${row.id}</td>
                                        <td>${row.user.username}</td>
                                        <td>${row.user.telephone}</td>
                                        <td>${row.money}</td>
                                        <td><fmt:formatDate value='${row.orderTime}' pattern='yyyy-MM-dd'/></td>
                                        <td>${row.payState==0?"未支付":"已支付"}</td>
                                        <td>${row.orderState==0?"未发货":(row.orderState==1?"已发货":row.orderState==2?"已签收":"已评价")}</td>
                                        <td class="text-center">
                                           <button type="button" class="btn bg-olive btn-xs" data-toggle="collapse"
                                               data-parent="dataList" href="#detail-${row.id}">详情</button>
                                           <c:if test="${row.orderState==0}">
                                               <button type="button" class="btn bg-olive btn-xs" onclick="dispatch('${row.id}')">发货</button>
                                           </c:if>
                                        </td>
                                    </tr>
									<tr id="detail-${row.id}" class="panel-collapse collapse">
										<td colspan="9">
											<div>
												订单详情
												<table
													class="table table-bordered table-striped table-hover dataTable">
													<thead>
														<tr>
															<th class="sorting_asc">产品ID</th>
															<th class="sorting">产品名称</th>
															<th class="sorting">购买数量</th>
															<th class="sorting">购买金额</th>
														</tr>
													</thead>
													<tbody>
														<!-- 将模板页中的静态样例数据行改为使用JSTL动态展现控制器中返回的模型数据 -->
														<c:forEach items="${row.orderItems}" var="orderItemrow">
															<tr>
																<td>${orderItemrow.product.id}</td>
																<td>${orderItemrow.product.name}</td>
																<td>${orderItemrow.buyNum}</td>
																<td>${orderItemrow.buyPrice}</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</td>
									</tr>
								</c:forEach>
                             </tbody>                             
                          </table>
                            <!--数据列表/-->

                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建" onclick='location.href="insert.action"'><i class="fa fa-file-o"></i> 新建</button>
                                        <button type="button" class="btn btn-default" title="删除" onclick='del();'><i class="fa fa-trash-o"></i> 删除</button>
                                        <button type="button" class="btn btn-default" title="开启" onclick='confirm("你确认要开启吗？")'><i class="fa fa-check"></i> 开启</button>
                                        <button type="button" class="btn btn-default" title="屏蔽" onclick='confirm("你确认要屏蔽吗？")'><i class="fa fa-ban"></i> 屏蔽</button>
                                        <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                                    </div>
                                </div>
                            </div>
                            <form class="form-inline" method="post"
								action="list.action">
								<div class="box-tools pull-right">
									<div class="has-feedback">
										<input type="text" class="form-control input-sm"
											placeholder="搜索" id="name" value="${product.name}"
								name="name" > <span
											class="glyphicon glyphicon-search form-control-feedback"></span>
									</div>
								</div>
							</form>
                            <!--工具栏/-->

                        </div>
                        <!-- 数据表格 /-->


                    </div>
                    <!-- /.box-body -->

                    <!-- .box-footer-->
					<div class="box-footer">
						<div class="pull-left">
							<div class="form-group form-inline">
								总共${pageInfo.pages}
								页，当前第${pageInfo.pageNum}页，共${pageInfo.total}条数据。 每页 <select
									class="form-control">
									<option ${pageInfo.pageSize=="10"?"selected='selected'":"pageInfo.pageSize=10"}>10</option>
									<option ${pageInfo.pageSize=="15"?"selected='selected'":"pageInfo.pageSize=15"}>15</option>
									<option ${pageInfo.pageSize=="20"?"selected='selected'":"pageInfo.pageSize=20"}>20</option>
									<option ${pageInfo.pageSize=="50"?"selected='selected'":"pageInfo.pageSize=50"}>50</option>
									<option ${pageInfo.pageSize=="80"?"selected='selected'":"pageInfo.pageSize=80"}>80</option>
								</select> 条
							</div>
						</div>
						<div class="box-tools  pull-right">
							<ul class="pagination">
								<li><a href="javascript:void(0)" aria-label="Previous"
									onclick="form(${pageInfo.firstPage})">首页</a></li>
								<li><a href="javascript:void(0)"
									onclick="form(${pageInfo.hasPreviousPage?pageInfo.prePage:pageInfo.pageNum})">上一页</a></li>
								<li><a href="javascript:void(0)"
									onclick="form(${pageInfo.hasNextPage?pageInfo.nextPage:pageInfo.pageNum})">下一页</a></li>
								<li><a href="javascript:void(0)" aria-label="Next"
									onclick="form(${pageInfo.lastPage})">尾页</a></li>
							</ul>
						</div>
					</div>
					<!-- /.box-footer-->


                </div>

            </section>
            <!-- 正文区域 /-->

        </div>
        <!-- 内容区域 /-->

        <!-- 底部导航 -->
		<%@ include file="Footer.jsp"%>
        <!-- 底部导航 /-->

    </div>


    <script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../plugins/raphael/raphael-min.js"></script>
    <script src="../plugins/morris/morris.min.js"></script>
    <script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="../plugins/knob/jquery.knob.js"></script>
    <script src="../plugins/daterangepicker/moment.min.js"></script>
    <script src="../plugins/daterangepicker/daterangepicker.js"></script>
    <script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
    <script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
    <script src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
    <script src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="../plugins/fastclick/fastclick.js"></script>
    <script src="../plugins/iCheck/icheck.min.js"></script>
    <script src="../plugins/adminLTE/js/app.min.js"></script>
    <script src="../plugins/treeTable/jquery.treetable.js"></script>
    <script src="../plugins/select2/select2.full.min.js"></script>
    <script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
    <script src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
    <script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
    <script src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
    <script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
    <script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
    <script src="../plugins/ckeditor/ckeditor.js"></script>
    <script src="../plugins/input-mask/jquery.inputmask.js"></script>
    <script src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <script src="../plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script src="../plugins/chartjs/Chart.min.js"></script>
    <script src="../plugins/flot/jquery.flot.min.js"></script>
    <script src="../plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="../plugins/flot/jquery.flot.pie.min.js"></script>
    <script src="../plugins/flot/jquery.flot.categories.min.js"></script>
    <script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
    <script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
    <script src="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
    <script src="../plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script>
        $(document).ready(function() {
            // 选择框
            $(".select2").select2();

            // WYSIHTML5编辑器
            $(".textarea").wysihtml5({
                locale: 'zh-CN'
            });
        });


        // 设置激活菜单
        function setSidebarActive(tagUri) {
            var liObj = $("#" + tagUri);
            if (liObj.length > 0) {
                liObj.parent().parent().addClass("active");
                liObj.addClass("active");
            }
        }


        $(document).ready(function() {

            // 激活导航位置
            setSidebarActive("order-list");

            // 列表按钮 
            $("#dataList td input[type='checkbox']").iCheck({
                checkboxClass: 'icheckbox_square-blue',
                increaseArea: '20%'
            });
            // 全选操作 
            $("#selall").click(function() {
                var clicks = $(this).is(':checked');
                if (!clicks) {
                    $("#dataList td input[type='checkbox']").iCheck("uncheck");
                } else {
                    $("#dataList td input[type='checkbox']").iCheck("check");
                }
                $(this).data("clicks", !clicks);
            });
        });
        
        // 分页脚本
        function form(pageNum) {
            $("#pageNum").val(pageNum);
            $("#searchForm").submit();
        }
    </script>
    <script>
		function dispatch(id){
			if(confirm('您确定进行该订单发货？')){                        
				$.ajax({
				    url:"${pageContext.request.contextPath}/order/update.action",
				    type:"POST",
				    traditional : "true",
				    dataType:"text",//预期服务器返回数据类型
				    data:{
				        "id":id,
				        "orderState":1
				    },
				    success:function(data){                        
				         alert("发货成功！");
				         $("#" + id).children('td').eq(7).text("已发货");
				         $("#" + id).children('td').eq(8).children('button').eq(1).remove();
				    }
				});
			}    
        }
    </script>
</body>

</html>