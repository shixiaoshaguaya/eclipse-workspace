package cn.lmu.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lmu.bookstore.dao.ProductMapper;
import cn.lmu.bookstore.pojo.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	public int createProduct(Product product) {
		return this.productMapper.createProduct(product);
	}

	public Product getProductById(String id) {
		return this.productMapper.getProductById(id);
	}

	public List<Product> getProductListWhere(Product product) {
		return this.productMapper.getProductList(product);
	}

	public int editProduct(Product product) {
		return this.productMapper.editProduct(product);
	}

	public int deleteProductById(String id) {
		return this.productMapper.deleteProduct(id);
	}

	public List<Product> getProductListByName(String title) {
		return this.productMapper.getProductListByName(title);
	}

	public PageInfo<Product> getProductListWhereByPage(Product product, Integer pageNum, Integer pageSize) {
		// 分页
		PageHelper.startPage(pageNum, pageSize);// page 指定页码，pageSize 为每页显示几条数据
		List<Product> list = this.productMapper.getProductList(product);// 调用查询
		PageInfo<Product> pageInfo = new PageInfo(list);
		return pageInfo;
	}

}
