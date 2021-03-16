package servlets;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.Book;
import service.BookService;

public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// �ϴ��ļ��洢Ŀ¼
	private static final String UPLOAD_DIRECTORY = "upload";
	// �ϴ�����
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String b_id = request.getParameter("b_id");
		String b_name = request.getParameter("b_name");
		String writer = request.getParameter("writer");
		String sort_id = request.getParameter("sort_id");
		Float price = Float.parseFloat(request.getParameter("price"));
		int total_number = Integer.parseInt(request.getParameter("total_number"));
		Book book = new Book(b_id, b_name, writer, sort_id, price, total_number, total_number, 0);
		BookService bs = new BookService();
		if (bs.add(book)) {
			response.getWriter().print("<script>alert('����鼮�ɹ�'); window.location.href='" + request.getContextPath()
					+ "/GetBookServlet'</script>");
		} else {
			response.getWriter().print("<script>alert('����鼮ʧ��'); window.location.href='" + request.getContextPath()
					+ "/admin/book/AddBook.jsp'</script>");
		}*/
		// ��ñ���Ϣ-���������ݿ�--��ִ�� Insert �������������--�������ض�����ʾ��Ʒ��¼
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String b_id = "";
		String b_name = "";
		String writer = "";
		String sort_id = "";
		float price = 0;
		int total_number = 0;
		String picturePath = "";
		try {
			// �����ϴ�����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
			factory.setSizeThreshold(MEMORY_THRESHOLD);
			// ������ʱ�洢Ŀ¼
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			// Ϊ�˽������ύ����Ŀ�������ļ��ϴ�����ʵ����һ�� FileUpload �����
			ServletFileUpload upload = new ServletFileUpload(factory);

			// ��������ļ��ϴ�ֵ
			upload.setFileSizeMax(MAX_FILE_SIZE);

			// �����������ֵ (�����ļ��ͱ�����)
			upload.setSizeMax(MAX_REQUEST_SIZE);

			// ���Ĵ���
			upload.setHeaderEncoding("UTF-8");
			// ������ʱ·�����洢�ϴ����ļ�
			// ���·����Ե�ǰӦ�õ�Ŀ¼������ getRealPath()����������·������Ӧ��ʵ��Ӳ��·��
			String uploadPath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;

			// ���Ŀ¼�������򴴽�
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			// ���� request���õ��ϴ��ļ��� FileItem ����
			List<FileItem> fileitems = upload.parseRequest(request);
			// ��������
			if (fileitems != null && fileitems.size() > 0) {
				for (FileItem fileitem : fileitems) {
					// �ж��Ƿ�Ϊ��ͨ�ֶ�
					if (fileitem.isFormField()) {
						// ����ֶ������ֶ�ֵ
						String name = fileitem.getFieldName();
						if (name.equals("b_id") && !fileitem.getString().equals("")) {
							b_id = fileitem.getString("utf-8");
						}
						if (name.equals("b_name") && !fileitem.getString().equals("")) {
							b_name = fileitem.getString("utf-8");
						}
						if (name.equals("writer") && !fileitem.getString().equals("")) {
							writer = fileitem.getString("utf-8");
						}
						if (name.equals("sort_id") && !fileitem.getString().equals("")) {
							sort_id = fileitem.getString("utf-8");
						}
						if (name.equals("price") && !fileitem.getString().equals("")) {
							price = Float.parseFloat(fileitem.getString());
						}
						if (name.equals("total_number") && !fileitem.getString().equals("")) {
							total_number = Integer.parseInt(fileitem.getString());
						}
					} else {// ������ͨ���򣬼��ļ��ϴ���Ŀ
						//����ļ������ƣ�����·����
						String fileName = new File(fileitem.getName()).getName();
						//����ļ�������·��������·���������ڱ����ļ�������

						String filePath = uploadPath + File.separator + fileName;
						// ����ͼƬ�����·������¼�����ݿ��в�Ʒ��ͼƬ·��
						picturePath = UPLOAD_DIRECTORY + File.separator + fileName;
						File storeFile = new File(filePath);
						// �ڿ���̨����ļ����ϴ�·��
						System.out.println(filePath);
						System.out.println(picturePath);
						// �����ļ���Ӳ��
						fileitem.write(storeFile);
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		Book book = new Book(b_id, b_name, writer, sort_id, price, total_number, total_number, 0);
		book.setPicturePath(picturePath);
		BookService bs = new BookService();
		if (bs.add(book)) {
			response.getWriter().print("<script>alert('����鼮�ɹ�'); window.location.href='" + request.getContextPath()
					+ "/GetBookServlet'</script>");
		} else {
			response.getWriter().print("<script>alert('����鼮ʧ��'); window.location.href='" + request.getContextPath()
					+ "/admin/book/AddBook.jsp'</script>");
		}
	}

}
