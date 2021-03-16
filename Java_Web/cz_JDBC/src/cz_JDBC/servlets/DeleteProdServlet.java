package cz_JDBC.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz_JDBC.service.ProductService;

public class DeleteProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得要删除的产品ID-》连接数据库--》执行delete命令删除产品--》请求重定向显示产品记录
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");//获取请求端（客户端）提交的表单项目数据
		ProductService ps = new ProductService();
		if (ps.delProductById(id)) {
			response.getWriter().print("<script>alert('删除成功'); window.location.href='" + request.getContextPath() + "/GetProdServlet'</script>");
		} else {
			response.getWriter().print("删除产品失败！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
