package service;

import javabean.Admin;
import javabean.User;

import dao.AdminDao;

import factory.BasicFactory;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao = BasicFactory.getFactory().getDao(AdminDao.class);

	public Admin getAdminByNameAndPsw(String username, String password) {
		// TODO Auto-generated method stub
		return dao.finAdminByNameAndPsw(username,password);
	}

	public Admin getAdminByName(String username) {
		// TODO Auto-generated method stub
		return dao.findAdminByName(username);
	}

	public Admin findAdminById(String id) {
		// TODO Auto-generated method stub
		return dao.findAdminById(id);
	}

	public void updateAdmin(Admin admin) {
		dao.updateAdmin(admin);
		
	}

}
