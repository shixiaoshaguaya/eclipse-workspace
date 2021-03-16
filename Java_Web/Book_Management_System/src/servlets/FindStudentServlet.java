package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import service.StudentService;

public class FindStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String s_id = request.getParameter("s_id");
		String s_name = request.getParameter("s_name");
		StudentService service = new StudentService();
		List<Student> studentList = service.findByManyCondition(s_id, s_name);
		request.setAttribute("studentsFromDB", studentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/student/find.jsp");
		dispatcher.forward(request, response);
	}

}
