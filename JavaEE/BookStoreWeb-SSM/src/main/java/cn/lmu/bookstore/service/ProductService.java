package cn.lmu.bookstore.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.lmu.bookstore.pojo.Product;

public interface ProductService {
	public int createProduct(Product product);

	public Product getProductById(String id);

	public List<Product> getProductListWhere(Product product);

	public int editProduct(Product product);

	public int deleteProductById(String id);

	public List<Product> getProductListByName(String title);

	public PageInfo<Product> getProductListWhereByPage(Product product, Integer pageNum, Integer pageSize);
}
