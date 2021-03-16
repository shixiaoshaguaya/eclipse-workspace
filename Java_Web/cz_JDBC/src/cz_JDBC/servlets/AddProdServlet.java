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

		// 上传文件存储目录
		private static final String UPLOAD_DIRECTORY = "upload";
		// 上传配置
		private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
		private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
		private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		// 获得表单信息-》连接数据库--》执行Insert插入命令保存数据--》请求重定向显示产品记录
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");//获取请求端（客户端）提交的表单项目数据
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
			response.getWriter().print("添加产品失败：" + ps.getMsg() + "<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
		*/
		// 获得表单信息-》连接数据库--》执行 Insert 插入命令保存数据--》请求重定向显示产品记录
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
			// 配置上传参数
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
			factory.setSizeThreshold(MEMORY_THRESHOLD);
			// 设置临时存储目录
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			// 为了解析表单提交的项目（含有文件上传），实例化一个 FileUpload 类对象
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 设置最大文件上传值
			upload.setFileSizeMax(MAX_FILE_SIZE);

			// 设置最大请求值 (包含文件和表单数据)
			upload.setSizeMax(MAX_REQUEST_SIZE);

			// 中文处理
			upload.setHeaderEncoding("UTF-8");
			// 构造临时路径来存储上传的文件
			// 这个路径相对当前应用的目录，利用 getRealPath()方法获得相对路径所对应的实际硬盘路径
			String uploadPath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;

			// 如果目录不存在则创建
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			// 解析 request，得到上传文件的 FileItem 对象
			List<FileItem> fileitems = upload.parseRequest(request);
			// 遍历集合
			if (fileitems != null && fileitems.size() > 0) {
				for (FileItem fileitem : fileitems) {
					// 判断是否为普通字段
					if (fileitem.isFormField()) {
						// 获得字段名和字段值
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
					} else {// 不是普通表单域，即文件上传项目
						//获得文件的名称（不含路径）
						String fileName = new File(fileitem.getName()).getName();
						//获得文件的完整路径（绝对路径），用于保存文件至磁盘

						String filePath = uploadPath + File.separator + fileName;
						// 生成图片的相对路径，记录到数据库中产品的图片路径
						picturePath = UPLOAD_DIRECTORY + File.separator + fileName;
						File storeFile = new File(filePath);
						// 在控制台输出文件的上传路径
						System.out.println(filePath);
						System.out.println(picturePath);
						// 保存文件到硬盘
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
					.print(" 添加产品失败： " + ps.getMsg() + "<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
	}
	
}
