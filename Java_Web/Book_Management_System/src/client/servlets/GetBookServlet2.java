package client.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import service.BookService;




public class GetBookServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetBookServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService ps=new BookService();
		List<Book> productLst=ps . getAll();
		this . getServletContext(). setAttribute("productsFromDB2", productLst);
		RequestDispatcher dispatcher=request.getRequestDispatcher( "/client/Show.jsp");
		dispatcher . forward(request , response) ;


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
/*response.getWriter().append("Served at: ").append(request.getContextPath());*/