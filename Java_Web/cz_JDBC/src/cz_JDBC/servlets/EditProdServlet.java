package cz_JDBC.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz_JDBC.beans.Product;
import cz_JDBC.service.ProductService;

public class EditProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡidֵ����ѯ���ݿ��øò�Ʒ��Ϣ
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id"); //��ñ���Ҫ�༭��ƷID
		System.out.print(id);
		Product product = null;
		if (id == null) {
			response.getWriter().print("��ѡ��Ҫ�༭�Ĳ�Ʒ��<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}else{
			ProductService ps = new ProductService();
			product = ps.getProductById(id);
		}
		if (product == null) {
			response.getWriter().print("����Ĳ�Ʒ�����ڣ������¹���<a href='" + request.getContextPath() + "/GetProdServlet'>�����Ʒ</a>");
		} else {
			request.setAttribute("product", product);//��ҩ�޸ĵĲ�Ʒ��Ϣ����request����
			RequestDispatcher
			dispatcher = request.getRequestDispatcher("/EditProduct.jsp");
			dispatcher.forward(request, response);
			//����ת��ת��༭ҳ��
		}
	}

	//����༭�ύ�ı���������޸����ݿ��в�Ʒ��Ϣ
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ñ���Ϣ-���������ݿ�--��ִ��Insert�������������--�������ض�����ʾ��Ʒ��¼
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");//��ȡ����ˣ��ͻ��ˣ��ύ�ı���Ŀ����
		String title = request.getParameter("title");
		float price = Float.parseFloat(request.getParameter("price"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date manufacture = new Date();
		try {
			manufacture = sdf.parse(request.getParameter("manufacture"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int stock = Integer.parseInt(request.getParameter("stock"));
		Product product = new Product(id, title, price, manufacture, stock);
		ProductService ps = new ProductService();
		if(ps.updateProduet(product)) {
			response.getWriter().print("<script>alert('�޸ĳɹ�'); window.location.href='" + request.getContextPath() + "/GetProdServlet'</script>");
		} else {
			response.getWriter().print("�޸Ĳ�Ʒʧ�ܣ�<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}
	}
}
