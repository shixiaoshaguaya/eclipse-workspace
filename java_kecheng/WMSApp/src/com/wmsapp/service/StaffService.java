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
	// ����������ѯ(����)
	public Staff getById(String id) throws Exception {
		return dao.getById(id);
	}
	// ����
	public boolean add(Staff Staff) throws Exception {
		return dao.add(Staff);
	}
	// ɾ��
	public boolean delete(String id) throws Exception {
		return dao.delete(id);
	}
	// ����
	public boolean update(Staff Staff) throws Exception {
		return dao.update(Staff);
	}
}
