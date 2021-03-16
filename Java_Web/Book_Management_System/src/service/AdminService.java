package service;

import java.util.List;

import beans.Admin;
import dao.AdminDao;
import utils.Page;

public class AdminService {
	AdminDao adminDao = new AdminDao();

	public Admin checkLogin(String a_id, String a_password) {
		Admin admin = null;
		admin = adminDao.find(a_id);
		if (admin != null) {
			if (admin.getA_password().equals(a_password)) {
				return admin;
			}
		}
		return null;
	}

	/**
	 * ���
	 * 
	 * @param admin
	 * @return
	 */
	public boolean add(Admin admin) {
		return this.adminDao.add(admin);
	}

	public Page<Admin> getAllByPage(int pageIndex, int pageSize) {
		return this.adminDao.findAll(pageIndex, pageSize);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public List<Admin> getAll() {
		return this.adminDao.getAll();
	}

	/**
	 * ��ȡ
	 * 
	 * @param a_id
	 * @return
	 */
	public Admin getById(String a_id) {
		return this.adminDao.find(a_id);
	}

	/**
	 * ɾ��
	 * 
	 * @param a_id
	 * @return
	 */
	public boolean deleteById(String a_id) {
		return this.adminDao.delete(a_id);
	}

	/**
	 * ����
	 * 
	 * @param admin
	 * @return
	 */
	public boolean update(Admin admin) {
		return this.adminDao.update(admin);
	}
}
