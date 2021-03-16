package client.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;
import service.BookService;

/**
 * Servlet implementation class chaxun
 */
public class chaxun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chaxun() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String b_id=request.getParameter("b_id"); //获得本次要编辑产品ID
		System.out.print(b_id);
		Book book=null;
		if(b_id==null)
		{
			response.getWriter().print("请选择要查询的图书！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}else
		{BookService ps=new BookService();
		book=ps.getById(b_id);
		if(book==null)
		{
			response.getWriter().print("查询的图书不存在！请重新选择，<a href='"+
					request.getContextPath()+"/GetBookServlet'>浏览图书</a>");
		}else
		{
			request.setAttribute("book",book);//把药修改的产品信息存入request对象
			RequestDispatcher
			dispatcher=request.getRequestDispatcher("/client/Query.jsp");
			dispatcher.forward(request,response);
			//请求转发转向编辑页面
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
