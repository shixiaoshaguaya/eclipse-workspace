package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChineseServelet
 */
public class ChineseServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.处理字符流的中文乱码问题（肯定会乱码）
		String data ="中国";
		// 2.处理服务器的编码，让这个编码支持中文
		//response.setCharacterEncoding("utf-8");
		// 3.处理浏览器端的编码
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=GB18030");
		// 4.获取字符流
		PrintWriter pw = response.getWriter();
		pw.print(data);
	}

	private void streamMethod(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		// 1.处理字节流的中文乱码问题（可能会出现乱码）
		String data ="中国";
		ServletOutputStream out= response.getOutputStream();
		// 2.处理乱码，服务器端的编码和浏览器端的编码保持一致
		// 3.让浏览器端的编码也是utf-8
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 4.让服务器端的中文编码格式是utf-8
		out.write(data.getBytes("utf-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
