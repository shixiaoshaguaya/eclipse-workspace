<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01  Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible"  content="IE=edge">
    <meta name="viewport"  content="width=device-width,  initial-scale=1">
    <!--产品图片预览相关-->
    <link rel="stylesheet"  href="../assets/css/jcarousel.connected-carousels.css" type="text/css">
    <title>结算下单</title>   
</head>
<body>
    <%@ include file="Header.jsp"%>

	<!-- list-cart start-->
	<section class="shopping-cart"> <!--  .shopping-cart -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="../home/index.action">Home</a></li>
					<li class="breadcrumb-item active">Check  Out</li>
				</ol>
			</div>
			<div class="col-md-12">
				 <!-- Accordions -->
				<div class="panel  panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">物流信息</h4>
					</div>
					<div class="shipping-outer">
						<form id="orderForm" action="../order/create.action" method="post">
							<div class="col-sm-4 col-md-4">
								<div class="row">
									<div class="col-md-12 counttry">
										<div class="lable">收货人</div>
										<input name="receiverName" placeholder="收货人姓名" type="text">
									</div>
								</div>
							</div>
							<div class="col-sm-4 col-md-4">
								<div class="col-md-12 counttry">
									<div class="lable">收货人联系电话</div>
									<input name="receiverPhone" placeholder="收货人联系电话" type="text">
								</div>
							</div>
							<div class="col-sm-12 col-md-12 counttry">
								<div class="lable">收货人联系地址</div>
								<input name="receiverAddress" placeholder="收货人联系地址" type="text">
							</div>
							<div class="col-sm-12 col-md-12 counttry">
								<a onclick="checkOut()" class="button red">提交订单</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		<!-- /.shopping-cart -->
	</section>
	<!-- list-cart end -->

	<%@ include file="Footer.jsp"%>
	
	<script type="text/javascript">
		function checkOut() {
			var formData = new  FormData(document.getElementById("orderForm"));
			$.ajax({
				url: "${pageContext.request.contextPath}/order/create.action",
				type: "POST",                   
				dataType: "text",//预期服务器返回数据类型                     
				async: false,
				cache: false,
				contentType: false,
				data: formData,
				processData: false,
				success: function(data) {
					if(data == 'true'){
						alert("提交订单成功！欢迎继续购物。");
						window.location.href="../home/index.action";
				    }else{
				    	alert(data);
				    }
				}
			});
		}
    </script>
</body>
</html>