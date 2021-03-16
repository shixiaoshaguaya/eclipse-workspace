package client.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import service.BookService;

public class EditBookServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditBookServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String b_id=request.getParameter("b_id"); //��ñ���Ҫ�༭��ƷID
		System.out.print(b_id);
		Book book=null;
		if(b_id==null)
		{
			response.getWriter().print("��ѡ��Ҫ�༭��ͼ�飡<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}else
		{BookService ps=new BookService();
		book=ps.getById(b_id);
		if(book==null)
		{
			response.getWriter().print("�༭��ͼ�鲻���ڣ�������ѡ��<a href='"+
					request.getContextPath()+"/GetBook'>���ͼ��</a>");
		}else
		{
			request.setAttribute("book",book);//��ҩ�޸ĵĲ�Ʒ��Ϣ����request����
			RequestDispatcher
			dispatcher=request.getRequestDispatcher("/client/EdiBook.jsp");
			dispatcher.forward(request,response);
			//����ת��ת��༭ҳ��
		}
		}
	}
	//����༭�ύ�ı���������޸����ݿ��в�Ʒ��Ϣ
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ñ���Ϣ-���������ݿ�--��ִ��Insert�������������--�������ض�����ʾ��Ʒ��¼
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String b_id=request.getParameter("b_id");//��ȡ����ˣ��ͻ��ˣ��ύ�ı���Ŀ����
		String b_name=request.getParameter("b_name");
		String writer=request.getParameter("writer");
		String sort_id=request.getParameter("sort_id");
		float price=Float.parseFloat(request.getParameter("price"));
		int total_number=Integer.parseInt(request.getParameter("total_number"));
		int current_number=Integer.parseInt(request.getParameter("current_number"));
		int borrow_number=Integer.parseInt(request.getParameter("borrow_number"));
		Book book=new Book(b_id,b_name,writer,sort_id,price,total_number,current_number,borrow_number);
		BookService ps=new BookService(); 
		if(ps.update(book))
		{
			response.getWriter().print("<script>alert('�޸ĳɹ�');window.location.href='"+request.getContextPath()+"/GetBook'</script>");
		}else
		{response.getWriter().print("�޸�ʧ�ܣ�<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}
	}
}