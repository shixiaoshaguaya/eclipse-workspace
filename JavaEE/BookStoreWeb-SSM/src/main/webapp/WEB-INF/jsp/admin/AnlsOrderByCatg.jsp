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
                <!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					ChartJS <small>Preview sample</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">Charts</a></li>
					<li class="active">ChartJS</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box box-success">
							<table>
								<tr>
									<td name="day">开始日期: <input type="date" name="startDate"
										id="startDate" /></td>
									<td name="day">结束日期：<input type="date" name="endDate"
										id="endDate" /></td>
									<td><input type="button" value="查 询" onclick="query()" /></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- BAR CHART -->
						<div class="box box-success">
							<div class="box-header with-border">
								<h3 class="box-title">分类别销售统计</h3>
								<div class="box-tools pull-right">
									<button type="button" class="btn btn-box-tool"
										data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
									<button type="button" class="btn btn-box-tool"
										data-widget="remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
							<div class="box-body">
								<div class="chart">
									<div id="barChart" style="height: 450px">
										</canvas>
									</div>
								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
						<!-- /.col (RIGHT) -->
					</div>
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<!-- page script -->
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
            setSidebarActive("product-list");

            // 列表按钮 
            $("#dataList td input[type='checkbox']").iCheck({
                checkboxClass: 'icheckbox_square-blue',
                increaseArea: '20%'
            });
        });
    </script>
    
    
    <script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/echarts-gl/dist/echarts-gl.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/echarts-stat/dist/ecStat.min.js"></script>
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript">
 		var dom = document.getElementById("barChart");
		var myChart = echarts.init(dom);
		var app = {};
		option = null;
		var posList = [ 'left', 'right', 'top', 'bottom', 'inside',
				'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
				'insideTopLeft', 'insideTopRight', 'insideBottomLeft',
				'insideBottomRight' ];
		app.configParameters = {
			rotate : {
				min : -90,
				max : 90
			},
			align : {
				options : {
					left : 'left',
					center : 'center',
					right : 'right'
				}
			},
			verticalAlign : {
				options : {
					top : 'top',
					middle : 'middle',
					bottom : 'bottom'
				}
			},
			position : {
				options : echarts.util.reduce(posList, function(map, pos) {
					map[pos] = pos;
					return map;
				}, {})
			},
			distance : {
				min : 0,
				max : 100
			}
		};
		app.config = {
			rotate : 90,
			align : 'left',
			verticalAlign : 'middle',
			position : 'insideBottom',
			distance : 15,
			onChange : function() {
				var labelOption = {
					normal : {
						rotate : app.config.rotate,
						align : app.config.align,
						verticalAlign : app.config.verticalAlign,
						position : app.config.position,
						distance : app.config.distance
					}
				};
				myChart.setOption({
					series : [ {
						label : labelOption
					}, {
						label : labelOption
					}, {
						label : labelOption
					}, {
						label : labelOption
					} ]
				});
			}
		};
		var labelOption = {
			show : true,
			position : app.config.position,
			distance : app.config.distance,
			align : app.config.align,
			verticalAlign : app.config.verticalAlign,
			rotate : app.config.rotate,
			formatter : '{c} {name|{a}}',
			fontSize : 16,
			rich : {
				name : {
					textBorderColor : '#fff'
				}
			}
		};
	</script>
	<script>
		function formatDate(date) {
			var date = new Date(date);
			var YY = date.getFullYear() + '-';
			var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1)
					: date.getMonth() + 1)
					+ '-';
			var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date
					.getDate());
			var hh = (date.getHours() < 10 ? '0' + date.getHours() : date
					.getHours())
					+ ':';
			var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date
					.getMinutes())
					+ ':';
			var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date
					.getSeconds());
			return YY + MM + DD;
		}
		function query() {
			var startDate = $('#startDate').val();
			var endDate = $('#endDate').val();
			console.log(startDate);
			console.log(endDate);
			var strUrl = '${pageContext.request.contextPath}/analyse/anlsOrderByCatg.action';
			var params = {
				'startDate' : startDate,
				'endDate' : endDate
			}
			$.ajax({
				url : strUrl,
				type : 'post',
				dataType : 'json',
				data : JSON.stringify(params),
				contentType : "application/json;charset=UTF-8",
				success : function(response) {
					var categorys = [];
					var buyNums = [];
					var buyMoneys = [];
					$.each(response, function(index, obj) {
						categorys.push(obj.category_name);
						buyNums.push(obj.buyNum);
						buyMoneys.push(obj.buyMoney);
					})
					myChart.hideLoading(); // 隐藏加载动画
					myChart.setOption({
						color : [ '#003366', '#006699', '#4cabce', '#e5323e' ],
						tooltip : {
							trigger : 'axis',
							axisPointer : {
								type : 'shadow'
							}
						},
						legend : {
							data : [ '购买数量', '购买金额' ]
						},
						toolbox : {
							show : true,
							orient : 'vertical',
							left : 'right',
							top : 'center',
							feature : {
								mark : {
									show : true
								},
								dataView : {
									show : true,
									readOnly : false
								},
								magicType : {
									show : true,
									type : [ 'line', 'bar', 'stack', 'tiled' ]
								},
								restore : {
									show : true
								},
								saveAsImage : {
									show : true
								}
							}
						},
						xAxis : [ {
							type : 'category',
							axisTick : {
								show : false
							},
							data : categorys
						} ],
						yAxis : [ {
							type : 'value'
						} ],
						series : [ {
							name : '购买数量',
							type : 'bar',
							barGap : 0,
							label : labelOption,
							data : buyNums
						}, {
							name : '购买金额',
							type : 'bar',
							label : labelOption,
							data : buyMoneys
						} ]
					});
				}
			});
		}
	</script>
</body>

</html>