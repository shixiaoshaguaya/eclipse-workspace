package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import service.BookService;

public class AddBookServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String b_id = request.getParameter("b_id");
		String b_name = request.getParameter("b_name");
		String writer = request.getParameter("writer");
		String sort_id = request.getParameter("sort_id");
		Float price = Float.parseFloat(request.getParameter("price"));
		int total_number = Integer.parseInt(request.getParameter("total_number"));
		Book book = new Book(b_id, b_name, writer, sort_id, price, total_number, total_number, 0);
		BookService bs = new BookService();
		if (bs.add(book)) {
			response.getWriter().print("<script>alert('添加书籍成功'); window.location.href='" + request.getContextPath()
					+ "/GetBookServlet'</script>");
		} else {
			response.getWriter().print("<script>alert('添加书籍失败'); window.location.href='" + request.getContextPath()
					+ "/admin/book/AddBook.jsp'</script>");
		}
	}

}
