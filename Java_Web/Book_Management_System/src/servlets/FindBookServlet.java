package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import service.BookService;

public class FindBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String b_id = request.getParameter("b_id");
		String b_name = request.getParameter("b_name");
		String writer = request.getParameter("writer");
		BookService service = new BookService();
		List<Book> bookList = service.findByManyCondition(b_id, b_name, writer);
		if (bookList != null) {
		request.setAttribute("booksFromDB", bookList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/book/find.jsp");
		dispatcher.forward(request, response);}
	}

}
