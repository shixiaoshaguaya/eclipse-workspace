package cz_JDBC.service;

import java.util.ArrayList;

import cz_JDBC.beans.Product;
import cz_JDBC.dao.ProductDao;
import cz_JDBC.utils.Page;

public class ProductService {
	ProductDao prodDao;
	String msg;

	public String getMsg() {
		return msg;
	}

	public ProductService() {
		super();
		prodDao = new ProductDao();
		msg = "";
	}

	// 新增商品功能
	public boolean addProduct(Product product) {
		if (this.existProduct(product.getId())) {
			this.msg = "该产品编号已存在，请修改新产品的编号！";
			return false;
		}
		if (this.prodDao.insert(product)) {
			this.msg = "增加产品成功！";
			return true;
		} else {
			this.msg = "增加产品失败！";
			return false;
		}
	}

	// 检测是否已存在某商品
	public boolean existProduct(String id) {
		if (this.prodDao.find(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	// 获取所有商品列表
	public ArrayList<Product> getAllProduct() {
		return this.prodDao.findAll();
	}
	
	public Page<Product> getAllProductByPage(int pageIndex, int pageSize) {
		return this.prodDao.findAll(pageIndex, pageSize);
	}

	// 获取指定商品
	public Product getProductById(String id) {
		return this.prodDao.find(id);
	}

	// 删除指定商品
	public boolean delProductById(String id) {
		return this.prodDao.delete(id);
	}

	// 更新某商品
	public boolean updateProduet(Product product) {
		return this.prodDao.update(product);
	}
}
