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
		// ��Ӧ����صķ���
		// 2.�ַ�����������������
		PrintWriter pw = response.getWriter(); 
		String value="itcast===";
		//pw.print(value);
		pw.write(value);
	}
	private void streamMethod(HttpServletResponse response) throws IOException {
		// ��Ӧ����صķ���
		// 1.�ֽ����������������������
		ServletOutputStream out = response.getOutputStream();
		String value ="itcast";
		out.write(value.getBytes());
	}
	private void headerMethod(HttpServletResponse response) {
		// ����Ӧ��Ϣͷ�ķ���
		// ���û���������������������£����»ص���¼ҳ�����û�������������
		// 1.����״̬��
		response.setStatus(302);
		// 2.������Ӧͷ����ɶ��򵽵�¼ҳ��
		response.setHeader("Location", "/cz/login.html");
	}
	// ��Ӧ��صķ���
	private void hangMethod(HttpServletResponse response) throws IOException {
		response.sendError(404, "chapter04��Ŀ��������Դ������");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
