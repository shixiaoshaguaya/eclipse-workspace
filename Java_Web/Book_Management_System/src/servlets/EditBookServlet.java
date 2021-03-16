package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import service.BookService;

public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String b_id = request.getParameter("b_id");
		Book book = null;
		if (b_id == null) {
			response.getWriter().print("请选择要编辑的书籍！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		} else {
			BookService bs = new BookService();
			book = bs.getById(b_id);
		}
		request.setAttribute("book", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/book/EditBook.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String b_id = request.getParameter("b_id");
		String b_name = request.getParameter("b_name");
		String writer = request.getParameter("writer");
		String sort_id = request.getParameter("sort_id");
		Float price = Float.parseFloat(request.getParameter("price"));
		int total_number = Integer.parseInt(request.getParameter("total_number"));
		int current_number = Integer.parseInt(request.getParameter("current_number"));
		int borrow_number = Integer.parseInt(request.getParameter("borrow_number"));
		int increase = Integer.parseInt(request.getParameter("increase"));
		int reduce = Integer.parseInt(request.getParameter("reduce"));
		Book book = new Book(b_id, b_name, writer, sort_id, price, (total_number + increase - reduce),
				(current_number + increase - reduce), borrow_number);
		BookService bs = new BookService();
		if (bs.update(book)) {
			response.getWriter().print("<script>alert('修改成功'); window.location.href='" + request.getContextPath()
					+ "/GetBookServlet'</script>");
		} else {
			response.getWriter().print("修改书籍失败！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
	}
}
