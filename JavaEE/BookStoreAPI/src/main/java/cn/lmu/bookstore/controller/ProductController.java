package cn.lmu.bookstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import cn.lmu.bookstore.pojo.Product;
import cn.lmu.bookstore.service.CategoryService;
import cn.lmu.bookstore.service.ProductService;

@Controller
@RequestMapping("api")
public class ProductController {
	@Autowired // 控制器调用服务层中产品服务提供的产品功能
	private ProductService productService;
	@Autowired // 控制器调用服务层中产品服务提供的产品功能
	private CategoryService categoryService;

	// 获取产品列表(分页显示)
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Product> getProductlist(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize, Product product) {
		PageInfo<Product> pageInfo = this.productService.getProductListWhereByPage(product, pageNum, pageSize);
		return pageInfo;
	}

	// 根据ID获取指定产品
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Product getProduct(@PathVariable String id) {
		Product product = this.productService.getProductById(id);
		return product;
	}

	// 添加新的产品
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	@ResponseBody
	public String addProduct(MultipartFile file, Product product) throws IllegalStateException, IOException {
		product.setId(UUID.randomUUID().toString());
		System.out.println(product);
		String fileName = file.getOriginalFilename();
		String path = "D:\\dev_software\\tomcat-upload";
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

	// 根据ID删除指定产品
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteProduct(@PathVariable String id) {
		this.productService.deleteProductById(id);
		return "success";
	}

	// 更新产品
	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	@ResponseBody
	public String updateProduct(MultipartFile file, Product product) throws IllegalStateException, IOException {
		System.out.println(product);
		if (file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			String path = "D:\\dev_software\\tomcat-upload";
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
		}
		int rowCount = this.productService.editProduct(product);
		if (rowCount > 0) {
			return "OK";
		} else {
			return "ERROR";
		}
	}
}
