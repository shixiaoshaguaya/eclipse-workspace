package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import service.BookService;
import utils.Page;

public class GetBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 10;
		int pageIndex = 1;
		Object pageSizeStr = request.getParameter("pageSize");
		Object pageIndexStr = request.getParameter("pageIndex");
		if (pageSizeStr != null)
			pageSize = Integer.parseInt(pageSizeStr.toString());
		if (pageIndexStr != null)
			pageIndex = Integer.parseInt(pageIndexStr.toString());
		BookService bs = new BookService();
		Page<Book> bookList = bs.getAllByPage(pageIndex, pageSize);
		request.setAttribute("booksFromDB", bookList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/book/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
