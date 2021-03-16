package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import service.StudentService;

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String s_id = request.getParameter("s_id");
		String s_name = request.getParameter("s_name");
		String s_password = request.getParameter("s_password");
		String sex = request.getParameter("sex");
		String telephone = request.getParameter("telephone");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date s_date = new Date();
		try {
			s_date = sdf.parse(request.getParameter("s_date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student = new Student(s_id, s_name, s_password, sex, telephone, s_date);
		StudentService ss = new StudentService();
		if (ss.add(student)) {
			response.getWriter().print("<script>alert('添加学生成功'); window.location.href='" + request.getContextPath()
			+ "/GetStudentServlet'</script>");
		} else {
			response.getWriter().print("<script>alert('添加学生失败'); window.location.href='" + request.getContextPath()
			+ "/admin/student/AddStudent.jsp'</script>");
		}
	}

}
