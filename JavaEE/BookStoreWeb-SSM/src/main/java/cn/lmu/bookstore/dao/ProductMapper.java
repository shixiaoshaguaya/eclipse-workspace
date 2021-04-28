package cn.lmu.bookstore.dao;

import java.util.List;

import cn.lmu.bookstore.pojo.Product;

public interface ProductMapper {
	// 创建产品
	public int createProduct(Product product);

	// 获取某产品
	public Product getProductById(String id);

	// 获取符合条件的产品列表
	public List<Product> getProductList(Product product);

	public Integer getProductListCount(Product product);

	// 编辑某产品
	public int editProduct(Product product);

	// 删除产品
	public int deleteProduct(String id);
}
