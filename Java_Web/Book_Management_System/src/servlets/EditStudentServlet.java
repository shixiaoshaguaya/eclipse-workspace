package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import service.StudentService;

public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String s_id = request.getParameter("s_id");
		Student student = null;
		if (s_id == null) {
			response.getWriter().print("请选择要编辑的学生信息！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}else{
			StudentService ss = new StudentService();
			student = ss.getById(s_id);
		}
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/student/EditStudent.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String s_id = request.getParameter("s_id");
		String s_name = request.getParameter("s_name");
		String sex = request.getParameter("sex");
		String telephone = request.getParameter("telephone");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date s_date = new Date();
		try {
			s_date = sdf.parse(request.getParameter("s_date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student = new Student(s_id, s_name, sex, telephone, s_date);
		StudentService ss = new StudentService();
		if(ss.update(student)) {
			response.getWriter().print("<script>alert('修改成功'); window.location.href='" + request.getContextPath() + "/GetStudentServlet'</script>");
		} else {
			response.getWriter().print("修改学生信息失败！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
	}

}
