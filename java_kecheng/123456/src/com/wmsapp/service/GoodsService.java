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
	// ����������ѯ(����)
	public Goods getById(String id) throws Exception {
		return dao.getById(id);
	}
	// ����
	public boolean add(Goods goods) throws Exception {
		return dao.add(goods);
	}
	// ɾ��
	public boolean delete(String id) throws Exception {
		return dao.delete(id);
	}
	// ����
	public boolean update(Goods goods) throws Exception {
		return dao.update(goods);
	}
}
