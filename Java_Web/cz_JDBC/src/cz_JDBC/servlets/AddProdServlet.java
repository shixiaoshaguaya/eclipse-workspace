package cz_JDBC.servlets;

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

import cz_JDBC.beans.Product;
import cz_JDBC.service.ProductService;

public class AddProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		// �ϴ��ļ��洢Ŀ¼
		private static final String UPLOAD_DIRECTORY = "upload";
		// �ϴ�����
		private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
		private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
		private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		// ��ñ���Ϣ-���������ݿ�--��ִ��Insert�������������--�������ض�����ʾ��Ʒ��¼
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");//��ȡ����ˣ��ͻ��ˣ��ύ�ı���Ŀ����
		String title = request.getParameter("title");
		float price = Float.parseFloat(request.getParameter("price"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date manufacture = new Date();
		try {
			manufacture = sdf.parse(request.getParameter("manufacture"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int stock=Integer.parseInt(request.getParameter("stock"));
		Product product = new Product(id,title,price,manufacture,stock);
		ProductService ps = new ProductService();
		if (ps.addProduct(product)) {
			response.sendRedirect(request.getContextPath() + "/GetProdServlet");
		} else {
			response.getWriter().print("��Ӳ�Ʒʧ�ܣ�" + ps.getMsg() + "<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}
		*/
		// ��ñ���Ϣ-���������ݿ�--��ִ�� Insert �������������--�������ض�����ʾ��Ʒ��¼
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = "";
		String title = "";
		float price = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date manufacture = new Date();
		int stock = 0;
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
						if (name.equals("id") && !fileitem.getString().equals("")) {
							id = fileitem.getString("utf-8");
						}
						if (name.equals("title") && !fileitem.getString().equals("")) {
							title = fileitem.getString("utf-8");
						}
						if (name.equals("price") && !fileitem.getString().equals("")) {
							price = Float.parseFloat(fileitem.getString());
						}
						if (name.equals("stock") && !fileitem.getString().equals("")) {
							stock = Integer.parseInt(fileitem.getString());
						}
						if (name.equals("manufacture") && !fileitem.getString().equals("")) {
							try {
								manufacture = sdf.parse(fileitem.getString());
							} catch (ParseException e) {
								e.printStackTrace();
							}
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
		Product product = new Product(id, title, price, manufacture, stock);
		product.setPicturePath(picturePath);
		ProductService ps = new ProductService();
		if (ps.addProduct(product)) {
			response.sendRedirect(request.getContextPath() + "/GetProdServlet");
		} else {
			response.getWriter()
					.print(" ��Ӳ�Ʒʧ�ܣ� " + ps.getMsg() + "<INPUT type='button' onclick='history.go(-1)' value='����' />");
		}
	}
	
}
