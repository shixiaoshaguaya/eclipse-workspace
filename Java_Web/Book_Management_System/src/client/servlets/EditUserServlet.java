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

import beans.Student;
import service.BookService;
import service.StudentService;

public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String s_id=request.getParameter("s_id"); //��ñ���Ҫ�༭��ƷID
		System.out.print(s_id);
		Student student=null;
		if(s_id==null)
		{
			response.getWriter().print("��ѡ��Ҫ�༭���û���<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}else
		{StudentService ps=new StudentService();
		student=ps.getById(s_id);
		if(student==null)
		{
			response.getWriter().print("�༭���û������ڣ������±༭��<a href='"+
					request.getContextPath()+"/GetBookServlet'>���ͼ��</a>");
		}else
		{
			request.setAttribute("student",student);//��ҩ�޸ĵĲ�Ʒ��Ϣ����request����
			RequestDispatcher
			dispatcher=request.getRequestDispatcher("/client/EditUser.jsp");
			dispatcher.forward(request,response);
			//����ת��ת��༭ҳ��
		}
		}
	}
	//����༭�ύ�ı���������޸����ݿ��в�Ʒ��Ϣ
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ñ���Ϣ-���������ݿ�--��ִ��Insert�������������--�������ض�����ʾ��Ʒ��¼
		request. setCharacterEncoding ("utf-8") ;
		response.setContentType ("text/html ;charset=utf-8");
		String s_id=request.getParameter ("s_id");//��ȡ�����(�ͻ���)�ύ�ı���Ŀ����
		String s_password=request.getParameter("s_password");
		String s_name=request.getParameter("s_name");
		String sex=request.getParameter("sex");
		String telephone=request.getParameter("telephone");
		int s_number=Integer.parseInt(request.getParameter("s_number"));
		float s_money=Float.parseFloat(request.getParameter("s_money"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date s_date=new Date();
		try {
			s_date=sdf.parse(request.getParameter("s_date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s_identity=request.getParameter("s_identity");
		Student student=new Student(s_id,s_password,s_name,sex,telephone,s_number,s_money,s_date,s_identity);
		StudentService ps=new StudentService();
		if(ps.update2(student))
		{
			response.getWriter().print("<script>alert('�޸ĳɹ�');window.location.href='"+request.getContextPath()+"/GetBook'</script>");
		}else
		{response.getWriter().print("�޸�ʧ�ܣ�<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}
	}
}