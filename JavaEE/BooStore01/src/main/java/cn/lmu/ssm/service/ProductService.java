package cn.lmu.ssm.service;

import java.util.List;

import cn.lmu.ssm.pojo.Product;
import cn.lmu.ssm.pojo.SaleInfo;

//此处定义了服务层的接口（标准）
public interface ProductService {
	public List<Product> getProducts();

	public void insert(Product product);

	public void sale(SaleInfo saleInfo);

	public Product find(int id);

}
