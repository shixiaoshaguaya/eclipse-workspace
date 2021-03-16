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
		String b_id=request.getParameter("b_id"); //��ñ���Ҫ�༭��ƷID
		System.out.print(b_id);
		Book book=null;
		if(b_id==null)
		{
			response.getWriter().print("��ѡ��Ҫ��ѯ��ͼ�飡<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}else
		{BookService ps=new BookService();
		book=ps.getById(b_id);
		if(book==null)
		{
			response.getWriter().print("��ѯ��ͼ�鲻���ڣ�������ѡ��<a href='"+
					request.getContextPath()+"/GetBookServlet'>���ͼ��</a>");
		}else
		{
			request.setAttribute("book",book);//��ҩ�޸ĵĲ�Ʒ��Ϣ����request����
			RequestDispatcher
			dispatcher=request.getRequestDispatcher("/client/Query.jsp");
			dispatcher.forward(request,response);
			//����ת��ת��༭ҳ��
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
