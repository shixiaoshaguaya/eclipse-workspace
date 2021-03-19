package cn.lmu.ssm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.lmu.ssm.pojo.Product;
import cn.lmu.ssm.pojo.SaleInfo;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 在客户端GET请求时，响应请求进行产品列表显示
		// 1.请求服务层的产品功能，获取产品列表数据
		// 旧代码：使用New方式主动创建对象
		// ProductService productService = new ProductServiceImpl();

		// 改为采用Spring IOC将对象的创建工作交个Spring完成
		// 由于通过监听器实现了Spring容器的初始化工作，此处代码可以省略
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		ServletContext servletContext = this.getServletContext();
		// 获取当前Web
		// 如果要更好理解这些代码，建议了解Tomcat工作原理
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		ProductService productService = (ProductService) context.getBean("productService");

		// 获取URL中的type参数
		String operationName = request.getParameter("type");
		if (operationName == null) {
			operationName = "getList";// 未输入操作类型，默认按getList获取产品列表操作
		}
		// 根据type参数值决定操作
		switch (operationName) {
		case "insertOne":// 插入一条新产品
			// Product product=new Product("新产品",535);
			Product product = (Product) context.getBean("product1");
			productService.insert(product);
			List<Product> productsNew = productService.getProducts();
			request.setAttribute("products", productsNew);
			request.getRequestDispatcher("/Product.jsp").forward(request, response);
			break;
		case "saleOne":// 销售一件产品
			SaleInfo saleInfo = new SaleInfo();
			saleInfo.setProduct_id(1);
			saleInfo.setQuantity(10);
			productService.sale(saleInfo);
			List<Product> productsNew2 = productService.getProducts();
			request.setAttribute("products", productsNew2);
			request.getRequestDispatcher("/Product.jsp").forward(request, response);
			break;
		case "getOne"://
			int id = Integer.parseInt(request.getParameter("id"));
			Product productInfo = productService.find(id);
			request.setAttribute("productInfo", productInfo);
			request.getRequestDispatcher("/ProductInfo.jsp").forward(request, response);
			break;
		case "list":
		default:// 默认获取产品列表
			List<Product> products = productService.getProducts();
			// 2.将数据放入域对象（Page\Request\Session\Application）
			request.setAttribute("products", products);
			// 3.将请求转发（注意：不是请求重定向！！！！）至JSP页面，由JSP页面完成数据的最终呈现
			request.getRequestDispatcher("/Product.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
