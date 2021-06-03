package cn.lmu.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.lmu.bookstore.pojo.Category;
import cn.lmu.bookstore.pojo.Product;
import cn.lmu.bookstore.service.CategoryService;
import cn.lmu.bookstore.service.ProductService;

@Controller // Spring IOC控制反转，要求Spring进行该类对象实例化
@RequestMapping("home") // 响应用户的/product请求
public class HomeController {
	@Autowired // 控制器调用服务层中产品服务提供的产品功能
	private ProductService productService;
	@Autowired // 控制器调用服务层中产品服务提供的产品功能
	private CategoryService categoryService;

	@RequestMapping(value = "/index.action", method = { RequestMethod.POST, RequestMethod.GET })
	public String index(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize, Product product, Model model) {
		List<Category> categorys = this.categoryService.getCategoryList();
		model.addAttribute("categorys", categorys);
		PageInfo<Product> pageInfo = this.productService.getProductListWhereByPage(product, pageNum, pageSize);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("product", product);
		return "client/Index";// 转向由视图解析器去解析数据，此处明确视图页面为client/Index.jsp
	}

	@RequestMapping(value = "/details.action", method = { RequestMethod.POST, RequestMethod.GET })
	public String details(String pid, Model model) {
		Product product = this.productService.getProductById(pid);
		model.addAttribute("product", product);
		return "client/Details";// 转向由视图解析器去解析数据，此处明确视图页面为clientDetails.jsp
	}
}
