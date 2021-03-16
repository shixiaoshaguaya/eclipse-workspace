package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import beans.Book_Student;
import beans.Student;
import service.BookService;
import service.Book_StudentService;
import service.StudentService;

public class EditBook_StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		if (id == null) {
			response.getWriter().print("��ѡ��Ҫ�黹���鼮��<INPUT type='button' onclick='history.go(-1)' value='����' />");
		} else {
			Book_StudentService b_ss = new Book_StudentService();
			Book_Student book_student = b_ss.getById(id);
			String b_id = book_student.getB_id();
			BookService bs = new BookService();
			Book book = bs.getById(b_id);
			int current_number = book.getCurrent_number() + 1;
			book.setCurrent_number(current_number);
			String s_id = book_student.getS_id();
			StudentService ss = new StudentService();
			Student student = ss.getById(s_id);
			int s_number = student.getS_number() - 1;
			student.setS_number(s_number);
			Date practical_date = new Date(System.currentTimeMillis());
			book_student.setPractical_date(practical_date);
			Date return_date = book_student.getReturn_date();
			long day = (practical_date.getTime() - return_date.getTime() + 1000000) / (60 * 60 * 24 * 1000);
			if (day > 0) {
				float money = (float)day / 10;
				book_student.setMoney(money);
				response.getWriter().print("<script>alert('ͼ���ѳ���,�뽻���ڷ���" + money + "Ԫ')</script>");
			}
			if (b_ss.update(book_student) && bs.update(book) && ss.updates_number(student)) {
				response.getWriter().print("<script>alert('�黹�ɹ�'); window.location.href='" + request.getContextPath()
						+ "/GetBook_StudentServlet'</script>");
			} else {
				response.getWriter().print("�黹ʧ�ܣ�" + "<INPUT type='button' onclick='history.go(-1)' value='����' />");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
