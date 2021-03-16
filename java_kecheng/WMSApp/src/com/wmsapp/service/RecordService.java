package com.wmsapp.service;

import java.util.List;

import com.wmsapp.dao.RecordDao;
import com.wmsapp.model.Record;

public class RecordService {
	private RecordDao dao;
	public RecordService() {
		dao = new RecordDao();
	}
	public List<Record> getAll() throws Exception {
		return dao.getAll();
	}
	// 根据条件查询(主键)
	public Record getById(String id) throws Exception {
		return dao.getById(id);
	}
	// 插入
	public boolean add(Record record) throws Exception {
		return dao.add(record);
	}
	// 删除
	public boolean delete(String id) throws Exception {
		return dao.delete(id);
	}
	// 更新
	public boolean update(Record record) throws Exception {
		return dao.update(record);
	}
}
