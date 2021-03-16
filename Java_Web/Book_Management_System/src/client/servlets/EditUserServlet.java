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
		String s_id=request.getParameter("s_id"); //获得本次要编辑产品ID
		System.out.print(s_id);
		Student student=null;
		if(s_id==null)
		{
			response.getWriter().print("请选择要编辑的用户！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}else
		{StudentService ps=new StudentService();
		student=ps.getById(s_id);
		if(student==null)
		{
			response.getWriter().print("编辑的用户不存在！请重新编辑，<a href='"+
					request.getContextPath()+"/GetBookServlet'>浏览图书</a>");
		}else
		{
			request.setAttribute("student",student);//把药修改的产品信息存入request对象
			RequestDispatcher
			dispatcher=request.getRequestDispatcher("/client/EditUser.jsp");
			dispatcher.forward(request,response);
			//请求转发转向编辑页面
		}
		}
	}
	//处理编辑提交的保存操作，修改数据库中产品信息
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得表单信息-》连接数据库--》执行Insert插入命令保存数据--》请求重定向显示产品记录
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
		Student student=new Student(s_id,s_password,s_name,sex,telephone,s_number,s_money,s_date,s_identity);
		StudentService ps=new StudentService();
		if(ps.update2(student))
		{
			response.getWriter().print("<script>alert('修改成功');window.location.href='"+request.getContextPath()+"/GetBook'</script>");
		}else
		{response.getWriter().print("修改失败！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
	}
}