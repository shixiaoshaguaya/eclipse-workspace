<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,cz1110.beans.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用JSP技术显示产品信息</title>
</head>
<body>
	<%
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
	Map<String, Product> productMap = (HashMap<String, Product>) application.getAttribute("products");
	if (productMap == null) {
	%>
	产品数据未初始化，请先访问
	<a href="<%=request.getContextPath()%>/InitDataServlet">数据初始化页面 </a>！
	<%
		} else {
	%>
	<table border="1">
		<tr>
			<td>产品编号</td>
			<td>产品名称</td>
			<td>价格</td>
			<td>库存</td>
			<td>生产日期</td>
			<td>备注</td>
		</tr>
		<%
			Iterator<Map.Entry<String, Product>> iterator = productMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Product> item = iterator.next();
			Product product = item.getValue();
		%>
		<tr>
			<td><%=product.getId()%></td>
			<td><%=product.getTitle()%></td>
			<td><%=product.getPrice()%></td>
			<td><%=product.getStock()%></td>
			<td><%=format1.format(product.getManufacture())%></td>
			<td>
				<%
					if (product.getStock() < 10) {
					out.print("库存紧张，请尽快下单！");
				} else {
					out.print("库存充足，尽管甩单！");
				}
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
</body>
</html>