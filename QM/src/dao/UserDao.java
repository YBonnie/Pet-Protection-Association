package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javabean.User;


public interface UserDao  extends Dao{

	/**
	 * 根据用户名查找用户
	 * @param username 用户名
	 * @param conn 
	 * @return 查找到的用户,如果找不到返回null
 	 */
	User findUserByName(String username);

	/**
	 * 添加用户
	 * @param user 封装了用户信息的bean
	 * @param conn 
	 */
	void addUser(User user);

	/**
	 * 根据id删除用户
	 * @param id 要删除的用户id
	 */
	void delUser(String id);

	/**
	 * 修改指定id客户的状态
	 * @param id 客户id
	 * @param i 要更新的客户状态
	 */
	void updateUser(User user);

	/**
	 * 根据用户名密码查找用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 找到的用户bean
	 */
	User finUserByNameAndPsw(String username, String password);

	/**
	 * 根据id查找用户
	 * @param user_id
	 * @return
	 */
	

	User findUserById(String id);
	User findUserById(int id);

	List<User> getAllUser();

	void AdminupdateUser(User user);
	
	List<User> AdminfindUserByName(String userName);

	void delCustByIDWithTrans(Connection conn, String id) throws SQLException;
	
	
}
