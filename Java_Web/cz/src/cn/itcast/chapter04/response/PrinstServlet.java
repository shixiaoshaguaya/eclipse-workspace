package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrinstServlet
 */
public class PrinstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 响应体相关的方法
		// 2.字符流向浏览器输出数据
		PrintWriter pw = response.getWriter(); 
		String value="itcast===";
		//pw.print(value);
		pw.write(value);
	}
	private void streamMethod(HttpServletResponse response) throws IOException {
		// 响应体相关的方法
		// 1.字节流对象，向浏览器返回数据
		ServletOutputStream out = response.getOutputStream();
		String value ="itcast";
		out.write(value.getBytes());
	}
	private void headerMethod(HttpServletResponse response) {
		// 与相应消息头的方法
		// 在用户名和密码输入错误的情况下，重新回到登录页面让用户重新输入数据
		// 1.设置状态码
		response.setStatus(302);
		// 2.设置响应头，完成定向到登录页面
		response.setHeader("Location", "/cz/login.html");
	}
	// 响应相关的方法
	private void hangMethod(HttpServletResponse response) throws IOException {
		response.sendError(404, "chapter04项目的请求资源不存在");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
