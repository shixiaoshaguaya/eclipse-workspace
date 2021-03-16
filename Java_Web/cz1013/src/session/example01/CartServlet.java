package session.example01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Book> cart = null;
		boolean purFlag = true;
		HttpSession session = request.getSession(false);
		if(session == null) {
			purFlag = false;
		}else {
			cart = (List<Book>) session.getAttribute("cart");
			if (cart == null) {
				purFlag = false;
			}
		}
		if (!purFlag) {
			out.write("�Բ�������û�й����κ���Ʒ��<br/>");
		}else {
			out.write("�������ͼ���У�<br/>");
			double price = 0;
			for (Book book : cart) {
				out.write(book.getName() + "<br/>");
			}
		}
	}
}
