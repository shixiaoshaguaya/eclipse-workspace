package cz_JDBC.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz_JDBC.beans.Product;
import cz_JDBC.service.ProductService;
import cz_JDBC.utils.Page;

public class GetProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		ProductService ps = new ProductService();
		List<Product> productLst = ps.getAllProduct();
		this.getServletContext().setAttribute("productsFromDB2", productLst);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowProducts04.jsp");
		dispatcher.forward(request, response);
		*/
		int pageSize = 10;
		int pageIndex = 1;
		Object pageSizeStr = request.getParameter("pageSize");
		Object pageIndexStr = request.getParameter("pageIndex");
		if (pageSizeStr != null)
			pageSize = Integer.parseInt(pageSizeStr.toString());
		if (pageIndexStr != null)
			pageIndex = Integer.parseInt(pageIndexStr.toString());
		ProductService ps = new ProductService();
		Page<Product> productLst = ps.getAllProductByPage(pageIndex, pageSize);
		request.setAttribute("prodFromDBByPage", productLst);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowProducts05.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
