package client.servlets;

import java.io.IOException;
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
import service.StudentService;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("/client/RegisterUser.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print ("student") ;
		request. setCharacterEncoding ("utf-8") ;
		response.setContentType ("text/html ;charset=utf-8");
		String s_id=request.getParameter ("s_id");//获取请求端(客户端)提交的表单项目数据
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
		Student student=new Student();
		student.setS_id(s_id);
		student.setS_password (s_password);
		student.setS_name (s_name);
		student.setTelephone (telephone);
		student.setS_number (s_number);
		student.setS_money (s_money);
		student.setS_date (s_date);
		student.setS_identity (s_identity);
		StudentService us=new StudentService() ;
		try {
			if (us.add(student))
			{
				response.sendRedirect (request.getContextPath()+"/client/Login.jsp") ;
			}else
			{ 
				response.getWriter().print ("添加用户失败: "+us.getMsg() +"<INPUT type='button' onclick='history.go(-1)' value='返回' />");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
