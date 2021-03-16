package cz1110.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz1110.beans.Product;

/**
 * Servlet implementation class InitDataServlet
 */
@WebServlet("/InitDataServlet")
public class InitDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitDataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Map<String, Product> productMap = new HashMap<String, Product>();
		productMap.put("P001", new Product("P001", "华为Meta20", 10000, new Date(), 100));
		productMap.put("P002", new Product("P002", "小米机器人", 8000, new Date(), 10));
		productMap.put("P003", new Product("P003", "豪华别墅", 1000000, new Date(), 0));
		productMap.put("P004", new Product("P004", "联想笔记本", 6000, new Date(), 10));
		productMap.put("P005", new Product("P005", "奔驰S600", 3000000, new Date(), 5));
		productMap.put("P006", new Product("P006", "苹果X", 9600, new Date(), 100));
		productMap.put("P007", new Product("P007", "X-BOX", 7500, new Date(), 30));
		productMap.put("P008", new Product("P008", "360音箱", 1000, new Date(), 500));
		this.getServletContext().setAttribute("products", productMap);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("<a href='" + request.getContextPath() + "/ShowProducts01.jsp'>使用JSP显示产品信息</a>");
		response.getWriter().println("<a href='" + request.getContextPath() + "/ShowProducts02.jsp'>使用EL和JSTL技术显示产品信息</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
