package cn.lmu.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
