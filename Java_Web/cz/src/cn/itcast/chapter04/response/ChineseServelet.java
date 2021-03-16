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
		// 1.�����ַ����������������⣨�϶������룩
		String data ="�й�";
		// 2.����������ı��룬���������֧������
		//response.setCharacterEncoding("utf-8");
		// 3.����������˵ı���
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=GB18030");
		// 4.��ȡ�ַ���
		PrintWriter pw = response.getWriter();
		pw.print(data);
	}

	private void streamMethod(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		// 1.�����ֽ����������������⣨���ܻ�������룩
		String data ="�й�";
		ServletOutputStream out= response.getOutputStream();
		// 2.�������룬�������˵ı����������˵ı��뱣��һ��
		// 3.��������˵ı���Ҳ��utf-8
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 4.�÷������˵����ı����ʽ��utf-8
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
