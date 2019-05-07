package dao;
import java.sql.Connection;
import javabean.Admin;
import javabean.User;

public interface AdminDao  extends Dao{
	

	/**
	 * 根据用户名查找用户
	 * @param username 用户名
	 * @param conn 
	 * @return 查找到的用户,如果找不到返回null
 	 */
	Admin findAdminByName(String username);
	
	/**
	 * 根据用户名密码查找用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 找到的用户bean
	 */
	Admin finAdminByNameAndPsw(String username, String password);

	Admin findAdminById(String id);
	/**
	 * 修改指定id  Admin的状态
	 * @param id 客户id
	 * @param i 要更新的客户状态
	 */
	void updateAdmin(Admin admin);

	
	

}
