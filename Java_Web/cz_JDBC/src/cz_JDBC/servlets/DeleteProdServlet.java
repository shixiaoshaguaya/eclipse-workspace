package cz_JDBC.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz_JDBC.service.ProductService;

public class DeleteProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���Ҫɾ���Ĳ�ƷID-���������ݿ�--��ִ��delete����ɾ����Ʒ--�������ض�����ʾ��Ʒ��¼
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");//��ȡ����ˣ��ͻ��ˣ��ύ�ı���Ŀ����
		ProductService ps = new ProductService();
		if (ps.delProductById(id)) {
			response.getWriter().print("<script>alert('ɾ���ɹ�'); window.location.href='" + request.getContextPath() + "/GetProdServlet'</script>");
		} else {
			response.getWriter().print("ɾ����Ʒʧ�ܣ�<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
