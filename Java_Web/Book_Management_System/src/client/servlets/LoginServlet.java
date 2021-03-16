package client.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import beans.Student;
import service.StudentService;






/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("/client/ShowProducts04.jsp");
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System. out.print("bms");
		request. setCharacterEncoding ("utf-8") ;
		response. setContentType ("text/html; charset=utf-8");
		String s_id=request.getParameter ("s_id") ;//获取请求端(客户端)提交的表单项目数据
		String s_password=request.getParameter("s_password");
		String type = request.getParameter("type");
		StudentService us=new StudentService ();
		Student student = null;
		student = us.checkLogin(s_id,s_password);
		
		switch (type){
        case "reader":
        	if (student!=null )
    		{ request. getSession() . setAttribute ("student",student) ;
    		response . sendRedirect (request . getContextPath() +"/GetBook") ;
    		}else
    		{response.getWriter().print ("登录失败，用户名或密码错误，请重新登录。"+"<INPUT type= 'button' onclick- 'history.go(-1) ' value='返回' />");
    		}
        case "admin":
           
            break;
    }
		
		
		
		//连接数据库的方法或是调用后台的连接数据库的方法
		//查询，这里简写一下
		
	}

}
   