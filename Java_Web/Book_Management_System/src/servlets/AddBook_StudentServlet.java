package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class AddBook_StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String b_id = request.getParameter("b_id");
		BookService bs = new BookService();
		Book book = bs.getById(b_id);
		String s_id = request.getParameter("s_id");
		StudentService ss = new StudentService();
		Student student = ss.getById(s_id);
		if (book != null && student != null) {
			int s_number = student.getS_number();
			if (s_number > 5) {
				response.getWriter().print("<script>alert('���ֻ�ܽ���5��'); window.location.href='" + request.getContextPath()
				+ "/admin/book_student/AddBook_Student.jsp'</script>");
			} else {
				int current_number = book.getCurrent_number() - 1;// �鼮���е�ǰ�����ֶμ���1��
				int borrow_number = book.getBorrow_number() + 1;// �鼮���н��Ĵ����ֶ�����1��
				book.setCurrent_number(current_number);
				book.setBorrow_number(borrow_number);
				s_number += 1;// ѧ�������ѽ���������1
				student.setS_number(s_number);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date borrow_date = new Date();
				try {
					borrow_date = sdf.parse(request.getParameter("borrow_date"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Calendar calendar = Calendar.getInstance(); // ʹ��Calendar����������ڽ��мӼ�
				calendar.setTime(borrow_date);
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				borrow_date = calendar.getTime();
				Date return_date = new Date();
				try {
					return_date = sdf.parse(request.getParameter("borrow_date"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				calendar.setTime(return_date);
				calendar.add(Calendar.DAY_OF_MONTH, 31);
				return_date = calendar.getTime();// ��ȡ�Ӽ��Ժ��Date��������
				Book_Student book_student = new Book_Student(b_id, s_id, borrow_date, return_date);
				Book_StudentService b_ss = new Book_StudentService();
				if (b_ss.add(book_student) && bs.update(book) && ss.update(student)) {
					response.getWriter().print("<script>alert('���ĳɹ�'); window.location.href='" + request.getContextPath()
					+ "/GetBook_StudentServlet'</script>");
				} else {
					response.getWriter().print("<script>alert('����ʧ��'); window.location.href='" + request.getContextPath()
					+ "/admin/book_student/AddBook_Student.jsp'</script>");
				}
			}
		} else {
			response.getWriter().print("<script>alert('ͼ���Ż�ѧ�Ŵ���'); window.location.href='" + request.getContextPath()
					+ "/admin/book_student/AddBook_Student.jsp'</script>");
		}
	}

}
