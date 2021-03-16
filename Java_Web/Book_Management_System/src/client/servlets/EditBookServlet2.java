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
		String b_id=request.getParameter("b_id"); //获得本次要编辑产品ID
		System.out.print(b_id);
		Book book=null;
		if(b_id==null)
		{
			response.getWriter().print("请选择要编辑的图书！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}else
		{BookService ps=new BookService();
		book=ps.getById(b_id);
		if(book==null)
		{
			response.getWriter().print("编辑的图书不存在！请重新选择，<a href='"+
					request.getContextPath()+"/GetBook'>浏览图书</a>");
		}else
		{
			request.setAttribute("book",book);//把药修改的产品信息存入request对象
			RequestDispatcher
			dispatcher=request.getRequestDispatcher("/client/EdiBook.jsp");
			dispatcher.forward(request,response);
			//请求转发转向编辑页面
		}
		}
	}
	//处理编辑提交的保存操作，修改数据库中产品信息
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得表单信息-》连接数据库--》执行Insert插入命令保存数据--》请求重定向显示产品记录
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String b_id=request.getParameter("b_id");//获取请求端（客户端）提交的表单项目数据
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
			response.getWriter().print("<script>alert('修改成功');window.location.href='"+request.getContextPath()+"/GetBook'</script>");
		}else
		{response.getWriter().print("修改失败！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
	}
}