package cz1103.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz1103.javaBean.User;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		String password = request.getParameter("pwd");
		String rePassword = request.getParameter("repwd");
		String sex = request.getParameter("sex");
		if (!password.equals(rePassword)) {
			response.getWriter().print("两次输入密码不一致！请重新注册<a href='" + request.getContextPath() + "/register.jsp'>用户注册</a>");
		} else if (name == null || password == null || sex == null) {
			response.getWriter().print("信息不能为空！请重新注册<a href='" + request.getContextPath() + "/register.jsp'>用户注册</a>");
		} else {
			request.setAttribute("uName", name);
			request.setAttribute("uPassword", password);
			request.setAttribute("uSex", sex);
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setSex(sex);
			request.getSession().setAttribute("UserInfo", user);
			RequestDispatcher rdp = request.getRequestDispatcher("/regSuccess.jsp");
			rdp.forward(request, response);
		}
	}
}
