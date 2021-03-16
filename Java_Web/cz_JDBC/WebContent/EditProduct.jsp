<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑产品</title>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" scope="page"/>
	<form id="productAction_edit_do" name="Forml" action="${pageContext.request.contextPath}/EditProdServlet" method="post">
		<table cellSpacing="1" cellpadding="5" width="100%" align="center" bgColor="#eeeeee" style="border:1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afdlf3" colSpan="4" height="26"><strong><STRONG>编辑商品</STRONG></strong></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">商品编号：</td>
				<td bgColor="#ffffff"><input type="hidden" name="id" value="${requestScope.product.id}"/>${requestScope.product.id}</td>
				<td align="center" bgColor="#f5fafe">商品名称：</td>
				<td bgColor="#ffffff"><input type="text" name="title" value="${requestScope.product.title}"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">商品价格：</td>
				<td bgColor="#ffffff"><input type="text" name="price" value="${requestScope.product.price}"/></td>
				<td align="center" bgColor="#f5fafe">库存数量：</td>
				<td bgColor="#ffffff"><input type="text" name="stock" value="${requestScope.product.stock}"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">生产日期：</td>
				<td bgColor="#ffffff" colspan="3">
				<c:if test="${empty requestScope.product.manufacture}" var="flag">
					<input type="date" name="manufacture" value="<fmt:formatDate value='${now}' pattern='yyyy-MM-dd'/>"/>
				</c:if>
				<c:if test="${not flag}">
					<input type="date" name="manufacture" value="<fmt:formatDate value='${requestScope.product.manufacture}' pattern='yyyy-MM-dd'/>"/>
				</c:if>
				
				</td>
			</tr>
			<tr>
				<td style="width: 100%" align="center" bgColor="#f5fafe" colspan="4">
					<input type="submit" value="确定">
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="清空">
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="button" onclick="history.go(-1)" value="返回">
					<span id="Labell"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>