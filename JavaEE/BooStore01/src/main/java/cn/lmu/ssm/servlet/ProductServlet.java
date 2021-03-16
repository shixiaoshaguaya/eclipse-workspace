package cn.lmu.ssm.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.lmu.ssm.pojo.Product;
import cn.lmu.ssm.service.ProductService;
import cn.lmu.ssm.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * //在客户端GET请求时，响应请求进行产品列表显示 //1.请求服务层的产品功能，获取产品列表数据 //ProductService
		 * productService = new ProductServiceImpl();
		 * 
		 * //ApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * 
		 * ServletContext servletContext = this.getServletContext();
		 * WebApplicationContext context =
		 * WebApplicationContextUtils.getWebApplicationContext(servletContext);
		 * ProductService productService = (ProductService)
		 * context.getBean("productService"); List<Product> products =
		 * productService.getProducts(); //2.将数据放入域对象（Page\Request\Session\Application）
		 * request.setAttribute("products", products);
		 * //3.将请求转发（注意：不是请求重定向！！！！）至JSP页面，由JSP页面完成数据的最终呈现
		 * request.getRequestDispatcher("/Product.jsp").forward(request, response);
		 */

		// 手动加载Spring配置文件
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");

		// 利用web.xml配置实现web服务器启动时自动加载applicationContext.xml,获取ApplicationContext
		ServletContext servletContext = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		ProductService productService = context.getBean(ProductService.class);
		// ProductService productService = (ProductService)
		// context.getBean("productService");
		// 获取URL中的type参数
		String operationName = request.getParameter("type");
		if (operationName == null) {
			operationName = "getList";// 未输入操作类型，默认按getList获取产品列表操作
		}
		// 根据type参数值决定操作
		switch (operationName) {
		case "insertOne":// 插入一条新产品
			Product product = new Product("新产品", 535);
			productService.insert(product);
			List<Product> productsNew = productService.getProducts();
			request.setAttribute("products", productsNew);
			request.getRequestDispatcher("/Product.jsp").forward(request, response);
			break;
		default:// 默认获取产品列表
			List<Product> products = productService.getProducts();
			request.setAttribute("products", products);
			request.getRequestDispatcher("/Product.jsp").forward(request, response);
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
