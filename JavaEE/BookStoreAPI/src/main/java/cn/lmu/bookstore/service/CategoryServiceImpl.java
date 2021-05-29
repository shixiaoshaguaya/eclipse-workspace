package cn.lmu.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lmu.bookstore.dao.CategoryMapper;
import cn.lmu.bookstore.pojo.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired // Spring DI:依赖注入注解，注入一个产品数据访问类实例
	private CategoryMapper categoryMapper;

	public List<Category> getCategoryList() {
		return this.categoryMapper.getCategoryList();
	}
}
