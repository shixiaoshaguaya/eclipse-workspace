package cn.lmu.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lmu.bookstore.pojo.Product;
import cn.lmu.bookstore.service.ProductService;

@CrossOrigin(origins = "*") // 支持跨域
@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;

	/**
	 * API接口：返回JSON格式的产品列表
	 */
	@RequestMapping(value = "/list2.action", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<Product> list(Product product) {
		List<Product> products = this.productService.getProductListWhere(product);
		return products;
	}

	/**
	 * MVC方法：设置Model数据并请求JSP页面解析展示数据
	 */
	@RequestMapping(value = "/list.action", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Product product, Model model) {
		List<Product> products = this.productService.getProductListWhere(product);
		model.addAttribute("products", products);
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
	@RequestMapping("/delete.action")
	@ResponseBody
	public String delete(String id) {
		int rows = this.productService.deleteProductById(id);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
}
