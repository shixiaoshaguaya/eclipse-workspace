package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book_Student;
import service.Book_StudentService;
import utils.Page;

public class GetBook_StudentServlet extends HttpServlet {
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
		Book_StudentService b_ss = new Book_StudentService();
		Page<Book_Student> book_studentList = b_ss.getAllByPage(pageIndex, pageSize);
		request.setAttribute("book_studentsFromDB", book_studentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/book_student/list.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
