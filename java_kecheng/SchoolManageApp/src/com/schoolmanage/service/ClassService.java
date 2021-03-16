package com.schoolmanage.service;

import java.util.List;
import com.schoolmanageapp.dao.ClassDao;
import com.schoolmanageapp.model.Class;


public class ClassService {
	private ClassDao dao;
	public ClassService() {
		if(dao==null)
		{
			dao=new ClassDao();
		}
	}
	public List<Class> getAll() throws Exception{
		return dao.getAll();
	}

	//����������ѯ(����)
	public Class getById(String id) throws Exception {
		return dao.getById(id);
	}

	//����
	public boolean add(Class cls) throws Exception {
		return dao.add(cls);
	}

	//ɾ��
	public boolean delete(String id) throws Exception {
		return dao.delete(id);
	}

	//����
	public boolean update(Class cls) throws Exception {
		return dao.update(cls);
	}
}
