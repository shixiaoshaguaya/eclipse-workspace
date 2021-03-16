package servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book_Student;
import service.Book_StudentService;

public class EditBook_StudentServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		if (id == null) {
			response.getWriter().print("��ѡ��Ҫ������鼮��<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}else{
			Book_StudentService b_ss = new Book_StudentService();
			Book_Student book_student = b_ss.getById(id);
			int renew = book_student.getRenew();
			if (renew == 0) {
				renew = 1;
				Date return_date = book_student.getReturn_date();
				Calendar calendar = Calendar.getInstance(); // ʹ��Calendar����������ڽ��мӼ�
				calendar.setTime(return_date);
				calendar.add(Calendar.DAY_OF_MONTH, 16);
				return_date = calendar.getTime();
				book_student.setReturn_date(return_date);
				book_student.setRenew(renew);
				if(b_ss.update(book_student)) {
					response.getWriter().print("<script>alert('����ɹ�'); window.location.href='"+request.getContextPath() + "/GetBook_StudentServlet'</script>");
				} else {
					response.getWriter().print("����ʧ�ܣ�" + "<INPUT type='button' onclick='history.go(-1)' value='����' />");
				}
			} else {
				response.getWriter().print("<script>alert('ֻ������һ��'); window.location.href='" + request.getContextPath() + "/GetBook_StudentServlet'</script>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
