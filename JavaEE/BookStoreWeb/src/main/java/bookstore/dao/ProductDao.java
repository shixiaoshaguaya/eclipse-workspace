package bookstore.dao;

import java.util.ArrayList;
import java.util.List;

import bookstore.pojo.Product;

public class ProductDao {
	List<Product> products;
    public ProductDao() {         
          this.products= new ArrayList<Product>();
          products.add(new Product("小米手机", 1000));
          products.add(new Product("华为手机", 2000));
          products.add(new Product("苹果手机", 2500));
          products.add(new Product("小米手环", 500));
          products.add(new Product("华为笔记本电脑", 7000));
    }
    public List<Product> getProducts() {
          return this.products;
    }
}
