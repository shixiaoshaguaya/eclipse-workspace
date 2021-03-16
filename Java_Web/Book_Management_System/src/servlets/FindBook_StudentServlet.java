package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book_Student;
import service.Book_StudentService;

public class FindBook_StudentServlet extends HttpServlet {
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
		String s_id = request.getParameter("s_id");
		Book_StudentService service = new Book_StudentService();
		List<Book_Student> book_studentList = service.findByManyCondition(b_id, s_id);
		request.setAttribute("book_studentsFromDB", book_studentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/book_student/find.jsp");
		dispatcher.forward(request, response);
	}

}
