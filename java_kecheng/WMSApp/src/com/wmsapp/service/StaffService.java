package com.wmsapp.service;

import java.util.List;

import com.wmsapp.dao.StaffDao;
import com.wmsapp.model.Staff;

public class StaffService {
	private StaffDao dao;
	public StaffService() {
		dao = new StaffDao();
	}
	public List<Staff> getAll() throws Exception {
		return dao.getAll();
	}
	// 根据条件查询(主键)
	public Staff getById(String id) throws Exception {
		return dao.getById(id);
	}
	// 插入
	public boolean add(Staff Staff) throws Exception {
		return dao.add(Staff);
	}
	// 删除
	public boolean delete(String id) throws Exception {
		return dao.delete(id);
	}
	// 更新
	public boolean update(Staff Staff) throws Exception {
		return dao.update(Staff);
	}
}
