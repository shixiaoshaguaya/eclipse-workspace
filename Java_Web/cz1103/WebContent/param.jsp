<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/param.jsp">
		num1:<input type="text" name="num1"><br>
		num2:<input type="text" name="num"><br>
		num3:<input type="text" name="num"><br><br>
		<input type="submit" value="提交"/>&nbsp;&nbsp;
		<input type="submit" value="重置"/><hr>
		num1:${param.num1}<br>
		num2:${paramValues.num[0]}<br>
		num3:${paramValues.num[1]}<br>
	</form>
</body>
</html>