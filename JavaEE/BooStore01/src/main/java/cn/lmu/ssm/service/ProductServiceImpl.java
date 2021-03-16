package cn.lmu.ssm.service;

import java.util.List;

import cn.lmu.ssm.dao.ProductDao;
import cn.lmu.ssm.pojo.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public ProductServiceImpl() {
		super();
//		this.productDao = new ProductDao();
	}

	public List<Product> getProducts() {
		//服务层提供了产品列表功能，实际背后请求DAO的产品数据请求功能
		return this.productDao.getProducts();
	}

	@Override
	public void insert(Product product) {
		// TODO 自动生成的方法存根
		this.productDao.insert(product);
	}

}
