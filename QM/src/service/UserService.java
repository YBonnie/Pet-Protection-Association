package service;
import java.util.List;

import javabean.User;

public interface UserService extends Service{
	/**
	 * 注册用户
	 * @param user 封装了用户数据的userbean
	 */

	void regist(User user);

	void updateUser(User user);

	/**
	 * 根据用户名密码查找用户
	 * @param username
	 * @param password
	 */
	User getUserByNameAndPsw(String username, String password);

	User getUserByName(String username);
    
		/**
		 *根据用户的ID 查询 
		 *
		 * */
	User findUserById(String id);
	
     //获取user的所有数据
	List<User> getAllUser();
	
	/**
	 *根据用户的ID 删除
	 *
	 *
	 * */
	void delUser(String id);

//   管理员更新用户信息
	void AdminupdateUser(User user);

	List<User> AdminfindUserByName(String userName);

	void batchDel(String[] ids);
  
	
	User findUserByName(String username);


	
}
