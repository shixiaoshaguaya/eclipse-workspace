package cn.lmu.bookstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	 * 请求新增时返回新增页面
	 */
	@RequestMapping(value = "/insert.action", method = { RequestMethod.GET })
	public String insert(Model model) {
		List<Category> categorys = this.categoryService.getCategoryList();
		model.addAttribute("categorys", categorys);
		return "admin/Product-Edit";
	}

	/**
	 * 新增保存请求
	 */
	@RequestMapping(value = "/insert.action", method = { RequestMethod.POST })
	@ResponseBody
	public String save(Model model, HttpServletRequest request, MultipartFile file, Product product)
			throws IllegalStateException, IOException {
		product.setId(UUID.randomUUID().toString());
		System.out.println(product);
		String fileName = file.getOriginalFilename();
		String path = "D:\\apache-tomcat\\tomcat-upload";
		;
		File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
		if (!tempFile.getParentFile().exists()) {
			tempFile.getParentFile().mkdir();
		}
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
		file.transferTo(tempFile);
		product.setImgurl(tempFile.getName());
		int rowCount = this.productService.createProduct(product);
		if (rowCount > 0) {
			return "OK";
		} else {
			return "ERROR";
		}
	}

	@RequestMapping("/getProductById.action")
	@ResponseBody
	public Product getProductById(String id) {
		Product product = this.productService.getProductById(id);
		return product;
	}

	// 请求产品编辑页面
	@RequestMapping(value = "/edit.action", method = { RequestMethod.GET })
	public String edit(Model model, String id) {
		List<Category> categorys = this.categoryService.getCategoryList();
		model.addAttribute("categorys", categorys);
		Product product = this.productService.getProductById(id);
		model.addAttribute("product", product);// 将要编辑的产品原有数据传输到前端
		return "admin/Product-Edit";
	}

	/**
	 * 更新产品
	 */
	@RequestMapping(value = "/edit.action", method = { RequestMethod.POST })
	@ResponseBody
	public String update(Model model, HttpServletRequest request, MultipartFile file, Product product)
			throws IllegalStateException, IOException {
		System.out.println(product);
		if (file.getSize() > 0) {// 判断本次编辑中用户是否上传新的产品图片，如果上传则需要保存图片并修改数据库中图片路径
			String fileName = file.getOriginalFilename();
			String path = "D:\\apache-tomcat\\tomcat-upload";
			;
			File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
			if (!tempFile.getParentFile().exists()) {
				tempFile.getParentFile().mkdir();
			}
			if (!tempFile.exists()) {
				tempFile.createNewFile();
			}
			file.transferTo(tempFile);
			product.setImgurl(tempFile.getName());// 修改产品图片路径
		}
		// 如果没有修改图片路径，则意味着不修改数据库中相应字段的值！！！
		int rowCount = this.productService.editProduct(product);
		if (rowCount > 0) {
			return "OK";
		} else {
			return "ERROR";
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
