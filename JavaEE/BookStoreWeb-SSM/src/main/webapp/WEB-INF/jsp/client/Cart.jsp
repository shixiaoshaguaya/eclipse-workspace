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
    <title></title>   
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
					<li class="breadcrumb-item active">Cart</li>
				</ol>
			</div>
			<div class="col-md-12">
				<h2>购物车信息</h2>
				<table id="cartTable">
					<tr>
						<th>ID</th>
						<th>产品样图</th>
						<th>产品名称</th>
						<th>单价</th>
						<th>数量</th>
						<th>金额</th>
						<th></th>
					</tr>
					<c:forEach items="${cart.cartItemLst}" var="row">
						<tr id="${row.product.id}" class="productRow">
							<td><input name="ids" type="checkbox"
								value="${row.product.id}" class="checkbox"></td>
							<td><img src="../assets/images/elec-img4.jpg" alt="13"></td>
							<td>${row.product.name }</td>
							<td><strong>￥${row.price}</strong></td>
							<td><input type="number" name="quantity" min="1" max="500"
								value="${row.count}" onchange="change('${row.product.id}',event)"></td>
							<td><strong>￥${row.money}</strong></td>
						</tr>
					</c:forEach>
					<tr id="totalRow">
						<td>小计：</td>
						<td></td>
						<td></td>
						<td></td>
						<td><strong>${cart.totalCount}<strong></td>
						<td><strong>￥${cart.totalMoney}</strong></td>
					</tr>
				</table>
				<div class="col-sm-6  col-md-6">
					<a class="button" onclick='del();'>删除所选</a> <a class="button">清空购物车</a>
				</div>
				<div class="col-sm-6 col-md-6  text-right">
					<a href="../home/index.action" class="button  red">继续购物</a> <a
						href="../order/checkOut.action" class="button red">结算下单</a>
				</div>
			</div>
		</div>
		<!-- /.shopping-cart -->
	</section>
	<!-- list-cart end -->

	<%@ include file="Footer.jsp"%>
	
    <!--产品增加 减少相关JS-->
    <script  src="../assets/js/incrementing.js"></script>
    <!--  jcarousel Theme JavaScript 产品图片预览组件  -->
    <script type="text/javascript"  src="../assets/js/jquery.jcarousel.min.js"></script>
    <script type="text/javascript"  src="../assets/js/jcarousel.connected-carousels.js"></script>
    <script type="text/javascript"  src="../assets/js/jquery.elevatezoom.js"></script>
    <script>
		$('.zoom_01').elevateZoom({
			zoomType : "inner",
			cursor : "crosshair",
			zoomWindowFadeIn : 500,
			zoomWindowFadeOut : 750
		});
	</script>
	<script type="text/javascript">
       function change(productId, event) {
           //刷新页面上当前产品金额                 
           var price = $("#" +  productId).children('td').eq(3).text();
           price = price.substring(1);
           var count = event.target.value;
           $("#" +  productId).children('td').eq(5).text("￥" +  price * count);
           //刷新小计数量和金额
           var totalCount = 0;
           var totalMoney = 0;
           $("tr.productRow").each(                
                  function() {                     
                      totalCount =  parseInt(totalCount)
                              +  parseInt($(this).children('td').eq(4).find("input").val());                      
                      totalMoney =  parseInt(totalMoney)
                              +  parseInt($(this).children('td').eq(5).text()
                                     .substring(1));
                      
                  });
           $("#totalRow").children('td').eq(4).text(totalCount);
           $("#totalRow").children('td').eq(5).text("￥"  + totalMoney);
           var param = {
               'id' : productId,
               'count' : event.target.value
           };
           jQuery.ajax({
               url :  '${pageContext.request.contextPath}/cart/change.action',
               data : param,
               dataType : "JSON",
               type : "POST",
               success : function(data) {
                  if (data == true) {
                      alert("修改购物车成功！");
                  } else {
                      alert("修改购物车失败！");
                  }
               },
               error : function(XMLResponse)  {
                  alert(XMLResponse.responseText)
               }
           });
       }
       
       function del() {
    	   var idArr = new Array();
    	   $.each($(".checkbox:checked"), function() {
    		   // alert($(this).val());
    		   idArr.push($(this).val());
			});
    	   if (idArr.length == 0) {
    		   alert('您还未选择要删除的数据！');
    		   return;
			}
    	   if (confirm('您确定要删除所选记录？')) {
    		   $.ajax({
    			   url : "${pageContext.request.contextPath}/cart/delete.action",
    			   type : "POST",
    			   traditional : "true",
    			   dataType : "text",//预期服务器返回数据类型
    			   data : {
    				   "idArr" : idArr
    				},
    				success : function(data) {
    					alert("删除成功！");
    					$("input[name='ids']:checked").each(function() { // 遍历选中的checkbox
							$(this).parents("tr").remove(); //获取checkbox所在行并删                          
						});
					}
				});
			}
		}
	</script>
</body>
</html>