package com.wmsapp.service;

import java.util.List;

import com.wmsapp.dao.GoodsDao;
import com.wmsapp.model.Goods;

public class GoodsService {
	private GoodsDao dao;
	public GoodsService() {
		dao = new GoodsDao();
	}
	public List<Goods> getAll() throws Exception {
		return dao.getAll();
	}
	// 根据条件查询(主键)
	public Goods getById(String id) throws Exception {
		return dao.getById(id);
	}
	// 插入
	public boolean add(Goods goods) throws Exception {
		return dao.add(goods);
	}
	// 删除
	public boolean delete(String id) throws Exception {
		return dao.delete(id);
	}
	// 更新
	public boolean update(Goods goods) throws Exception {
		return dao.update(goods);
	}
}
