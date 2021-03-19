package cn.lmu.ssm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.lmu.ssm.pojo.Product;
import cn.lmu.ssm.pojo.SaleInfo;
//产品数据访问类，提供数据请求与处理功能，一般通过JDBC与数据库交互
//此处简化仅模拟数据请求功能
@Repository("productDao1")
public class ProductDao {
	
	  List<Product> products;
      public ProductDao() {         
			this.products = new ArrayList<Product>();
			products.add(new Product("小米手机", 1000));
			products.add(new Product("华为手机", 2000));
			products.add(new Product("苹果手机", 2500));
			products.add(new Product("小米手环", 500));
			products.add(new Product("华为笔记本电脑", 7000));
      }
      public List<Product> getProducts() {
    	  //实际开发中，用JDBC访问数据库获取数据返回
			return this.products;
      }

		public boolean insert(Product product) {
			return this.products.add(product);
		}

		public void sale(SaleInfo saleInfo) {
			// TODO Auto-generated method stub

		}

		public Product find(int id) {
			// TODO Auto-generated method stub
			return (Product) this.products;
		}
}
