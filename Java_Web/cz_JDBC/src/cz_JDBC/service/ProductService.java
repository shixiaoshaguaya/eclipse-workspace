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

	// ������Ʒ����
	public boolean addProduct(Product product) {
		if (this.existProduct(product.getId())) {
			this.msg = "�ò�Ʒ����Ѵ��ڣ����޸��²�Ʒ�ı�ţ�";
			return false;
		}
		if (this.prodDao.insert(product)) {
			this.msg = "���Ӳ�Ʒ�ɹ���";
			return true;
		} else {
			this.msg = "���Ӳ�Ʒʧ�ܣ�";
			return false;
		}
	}

	// ����Ƿ��Ѵ���ĳ��Ʒ
	public boolean existProduct(String id) {
		if (this.prodDao.find(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	// ��ȡ������Ʒ�б�
	public ArrayList<Product> getAllProduct() {
		return this.prodDao.findAll();
	}
	
	public Page<Product> getAllProductByPage(int pageIndex, int pageSize) {
		return this.prodDao.findAll(pageIndex, pageSize);
	}

	// ��ȡָ����Ʒ
	public Product getProductById(String id) {
		return this.prodDao.find(id);
	}

	// ɾ��ָ����Ʒ
	public boolean delProductById(String id) {
		return this.prodDao.delete(id);
	}

	// ����ĳ��Ʒ
	public boolean updateProduet(Product product) {
		return this.prodDao.update(product);
	}
}
