<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					用户管理 <small>用户新增表单</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="all-admin-index.html"><i
							class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="all-travellog-manage-list.html">用户管理</a></li>
					<li class="active">用户新增表单</li>
				</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content">

				<div class="box-body">

					<!--tab页-->
					<div class="nav-tabs-custom">

						<!--tab头-->
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab-form" data-toggle="tab">表单</a>
							</li>
						</ul>
						<!--tab头/-->

						<!--tab内容-->
						<div class="tab-content">

							<!--表单内容-->
							<form id="prodForm" action="inser.action" method="post"
								enctype="multipart/form-data">
								<div class="tab-pane active" id="tab-form">
									<div class="row data-type">
										<div class="col-md-2 title">用户ID</div>
										<div class="col-md-10 data text">
											<input type="hidden" id="id" value="${user.id}" name="id">${user.id}
										</div>
										<div class="col-md-2 title">姓名</div>
										<div class="col-md-10 data">
											<input type="text" class="form-control" placeholder="姓名"
												id="username" name="username" value="${user.username}">
										</div>
										<div class="col-md-2 title">密码</div>
										<div class="col-md-10 data">
											<input type="password" class="form-control" placeholder="密码"
												id="password" name="password" value="${user.password}">
										</div>
										<div class="col-md-2 title">性别</div>
										<div class="col-md-10 data">
											<input type="text" class="form-control" placeholder="性别"
												id="gender" name="gender" value="${user.gender}">
										</div>
										<div class="col-md-2 title">EMAIL</div>
										<div class="col-md-10 data">
											<input type="text" class="form-control" placeholder="EMAIL"
												id="email" name="email" value="${user.email}">
										</div>
										<div class="col-md-2 title">联系电话</div>
										<div class="col-md-10 data">
											<input type="text" class="form-control" placeholder="联系电话"
												id="telephone" name="telephone" value="${user.telephone}">
										</div>
										<div class="col-md-2 title">介绍</div>
										<div class="col-md-10 data">
											<input type="text" class="form-control" placeholder="介绍"
												id="introduce" name="introduce" value="${user.introduce}">
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">介绍</div>
										<input type="hidden" id="description2" name="description2">
										<div id="dayslist" class="panel-body">
											<div class="box box-info">
												<!-- /.box-header -->
												<div class="box-body pad">
													<textarea id="description" name="description"
														class="textarea" rows="10" cols="80">                                         
                    								</textarea>
												</div>
											</div>
											<!-- /.box -->
										</div>
									</div>
									<!--游记/-->
									<!--工具栏-->
									<div class="box-tools text-center">
										<button type="button" class="btn bg-maroon" onclick="save();">保存</button>
										<button type="button" class="btn bg-default"
											onclick="history.back(-1);">返回</button>
									</div>
									<!--工具栏/-->
								</div>
							</form>
							<!--表单内容/-->

						</div>
						<!--tab内容/-->

					</div>
					<!--tab页/-->


					<!-- .box-footer
        <div class="box-footer"></div>
        -->
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
            $('#description').val($('#descriptionVal').val());
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
            setSidebarActive("user-insert");

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
        
        // 保存
        function save(){
            var username = $("#username").val();
            var password = $('#password').val();
            var gender = $("#gender").val();
            var email = $("#email").val();
            var telephone = $("#telephone").val();
            var introduce = $("#introduce").val();
       		//采用默认JSON数据POST方式时，先构建JSON对象，本功能采用FORMDATA方式，该代码可忽略
	        var userData={
	            "id":"",
	            "username": $("#username").val(),
	            "password": $('#password').val(),
	            "gender": $("#gender").val(),
	            "email": $("#email").val(),
	            "telephone": $("#telephone").val(),
	            "introduce": $("#introduce").val()
	        };
        	//步骤1：利用FormData获取表单数据
        	var formData = new  FormData(document.getElementById("prodForm"));
        	//步骤2：利用Ajax发起新产品保存功能
        	if($("#id").val().length>0){
        		//更新  
                $.ajax({
                       url:"${pageContext.request.contextPath}/user/edit.action",
                       type:"POST",
                       dataType:"text",//预期服务器返回数据类型
                       async: false,  
                       cache: false,        
                       contentType: false,
                       data: formData,
                       processData: false,
                       success: function(data){
	                       alert(data);
	                       alert("更新成功！");   
                       }
                   });
        	}else{
        		//新增
	            $.ajax({
	            	url:"${pageContext.request.contextPath}/user/insert.action",
	                type:"POST",
	                //dataType:"text",//预期服务器返回数据类型
                    //async: false,  
                    //cache: false,        
                    //contentType: false,
                    //data: formData,
                    //processData: false,
	                data: {
	                	"username": username,
	    	            "password": password,
	    	            "gender": gender,
	    	            "email": email,
	    	            "telephone": telephone,
	    	            "introduce": introduce
	                },
	                success: function(data){
		                alert(data);
		                alert("保存成功！");   
	                }
	            });
        	}
       }
    </script>
</body>

</html>