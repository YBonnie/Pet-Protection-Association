package service;

import javabean.Admin;

public interface AdminService extends Service{


	/**
	 * 根据用户名密码查找用户
	 * @param username
	 * @param password
	 */
	Admin getAdminByNameAndPsw(String username, String password);

	Admin getAdminByName(String username);

	Admin findAdminById(String id);

	void updateAdmin(Admin admin);

}
