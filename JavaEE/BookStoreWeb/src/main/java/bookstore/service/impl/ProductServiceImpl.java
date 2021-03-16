package bookstore.service.impl;

import java.util.List;

import bookstore.dao.ProductDao;
import bookstore.pojo.Product;
import bookstore.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao=new ProductDao();
    public List<Product> getProducts() {            
          return this.productDao.getProducts();
    }
}
