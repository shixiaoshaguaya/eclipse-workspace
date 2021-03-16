package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;

public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String b_id = request.getParameter("b_id");
		BookService bs = new BookService();
		if (bs.deleteById(b_id)) {
			response.getWriter().print("<script>alert('É¾³ý³É¹¦'); window.location.href='" + request.getContextPath() + "/GetBookServlet'</script>");
		} else {
			response.getWriter().print("É¾³ýÊé¼®Ê§°Ü£¡<INPUT type='button' onclick='history.go(-1)' value='·µ»Ø' />");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
