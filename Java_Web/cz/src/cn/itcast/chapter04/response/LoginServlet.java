package cn.itcast.chapter04.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.��ȡ��¼���û���������
		String name = request.getParameter("username");
		String password = request.getParameter("psw");
		// 2.�ж��û����������Ƿ���ȷ
		if(name.equals("admin") && password.equals("123")) {//�����������������ȷ��
			response.sendRedirect("/cz/welcome.html");
		} else {//��¼ʧ��
			response.sendRedirect("/cz/login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
