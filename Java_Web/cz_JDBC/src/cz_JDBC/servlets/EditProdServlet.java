package cz_JDBC.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz_JDBC.beans.Product;
import cz_JDBC.service.ProductService;

public class EditProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取id值并查询数据库获得该产品信息
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id"); //获得本次要编辑产品ID
		System.out.print(id);
		Product product = null;
		if (id == null) {
			response.getWriter().print("请选择要编辑的产品！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}else{
			ProductService ps = new ProductService();
			product = ps.getProductById(id);
		}
		if (product == null) {
			response.getWriter().print("购买的产品不存在！请重新购买，<a href='" + request.getContextPath() + "/GetProdServlet'>浏览商品</a>");
		} else {
			request.setAttribute("product", product);//把药修改的产品信息存入request对象
			RequestDispatcher
			dispatcher = request.getRequestDispatcher("/EditProduct.jsp");
			dispatcher.forward(request, response);
			//请求转发转向编辑页面
		}
	}

	//处理编辑提交的保存操作，修改数据库中产品信息
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得表单信息-》连接数据库--》执行Insert插入命令保存数据--》请求重定向显示产品记录
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");//获取请求端（客户端）提交的表单项目数据
		String title = request.getParameter("title");
		float price = Float.parseFloat(request.getParameter("price"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date manufacture = new Date();
		try {
			manufacture = sdf.parse(request.getParameter("manufacture"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int stock = Integer.parseInt(request.getParameter("stock"));
		Product product = new Product(id, title, price, manufacture, stock);
		ProductService ps = new ProductService();
		if(ps.updateProduet(product)) {
			response.getWriter().print("<script>alert('修改成功'); window.location.href='" + request.getContextPath() + "/GetProdServlet'</script>");
		} else {
			response.getWriter().print("修改产品失败！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
	}
}
