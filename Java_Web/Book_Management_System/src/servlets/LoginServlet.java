package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Admin;
import beans.Student;
import service.AdminService;
import service.StudentService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		if ("admin".equals(type)) {
			AdminService as = new AdminService();
			Admin admin = null;
			admin = as.checkLogin(id, password);
			if (admin != null) {
				request.getSession().setAttribute("admin", admin);
				response.sendRedirect(request.getContextPath() + "/admin/login/index.jsp");// Ìø×ªÒ³Ãæ
			} else {
				response.getWriter()
						.print("µÇÂ¼Ê§°Ü£¬ÕËºÅ»òÃÜÂë´íÎó£¬ÇëÖØĞÂµÇÂ¼¡£<INPUT type='button' onclick='history.go(-1)' value='·µ»Ø' />");
			}
		} else {
			StudentService ss = new StudentService();
			Student student = null;
			student = ss.checkLogin(id, password);
			if (student != null) {
				request.getSession().setAttribute("student", student);
				response.sendRedirect(request.getContextPath() + "/GetBook");// Ìø×ªÒ³Ãæ
			} else {
				response.getWriter()
						.print("µÇÂ¼Ê§°Ü£¬Ñ§ºÅ»òÃÜÂë´íÎó£¬ÇëÖØĞÂµÇÂ¼¡£<INPUT type='button' onclick='history.go(-1)' value='·µ»Ø' />");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
