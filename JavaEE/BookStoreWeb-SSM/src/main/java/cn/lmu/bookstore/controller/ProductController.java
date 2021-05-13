package cn.lmu.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.lmu.bookstore.pojo.Category;
import cn.lmu.bookstore.pojo.Product;
import cn.lmu.bookstore.service.CategoryService;
import cn.lmu.bookstore.service.ProductService;

@CrossOrigin(origins = "*") // 支持跨域
@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired // 控制器调用服务层中产品服务提供的产品功能
	private CategoryService categoryService;

	/**
	 * API接口：返回JSON格式的产品列表
	 */
	@RequestMapping(value = "/list2.action", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<Product> list(Product product) {
		List<Product> products = this.productService.getProductListWhere(product);
		return products;
	}

//	@RequestMapping(value = "/search.action", method = { RequestMethod.POST, RequestMethod.GET })
//	public String list2(String title, Model model) {
//		List<Product> products = this.productService.getProductListByName(title);
//		model.addAttribute("products", products);
//		model.addAttribute("title", title);
//		return "admin/products2";// 转向由视图解析器去解析数据，此处明确视图页面为admin/products.jsp
//	}

//	@RequestMapping(value = "/search.action", method = { RequestMethod.POST, RequestMethod.GET })
//	public String list3(Product product, Model model) {
//		List<Category> categorys = this.categoryService.getCategoryList();
//		model.addAttribute("categorys", categorys);
//		List<Product> products = this.productService.getProductListWhere(product);
//		model.addAttribute("products", products);
//		model.addAttribute("product", product);
//		return "admin/products2";// 转向由视图解析器去解析数据，此处明确视图页面为admin/products.jsp
//	}

	/**
	 * MVC方法：设置Model数据并请求JSP页面解析展示数据
	 */
	@RequestMapping(value = "/list.action", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize, Product product, Model model) {
		List<Category> categorys = this.categoryService.getCategoryList();
		model.addAttribute("categorys", categorys);
//		List<Product> products = this.productService.getProductListWhere(product);
//		model.addAttribute("products", products);
		PageInfo<Product> pageInfo = this.productService.getProductListWhereByPage(product, pageNum, pageSize);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("product", product);
		return "admin/products2";
	}

	/**
	 * 创建
	 */
	@RequestMapping(value = "/create.action")
	@ResponseBody
	public String Create(Product product) {
		// 执行Service层中的创建方法，返回的是受影响的行数
		int rows = this.productService.createProduct(product);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

	@RequestMapping("/getProductById.action")
	@ResponseBody
	public Product getProductById(String id) {
		Product product = this.productService.getProductById(id);
		return product;
	}

	/**
	 * 更新产品
	 */
	@RequestMapping("/update.action")
	@ResponseBody
	public String update(Product product) {
		int rows = this.productService.editProduct(product);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

	/**
	 * 删除产品
	 */
	@RequestMapping(value = "/delete.action", method = { RequestMethod.POST })
	@ResponseBody
	public String delete(@RequestParam(value = "idArr") String[] idArr) {
		this.productService.deleteProductByIds(idArr);
		return "success";
	}
}
