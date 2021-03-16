package client.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String s_id=request.getParameter("s_id");//��ȡ����ˣ��ͻ��ˣ��ύ�ı���Ŀ����
		StudentService ps=new StudentService();
		if(ps.deleteById(s_id))
		{response.getWriter().print("<script>alert('ע���ɹ�');window.location.href='"+request.getContextPath()+"/client/Login.jsp'</script>");}
		else
		{
			response.getWriter().print("ע��ʧ�ܣ�<INPUT type='button' onclick='history.go(-1)' value='����' />");
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
