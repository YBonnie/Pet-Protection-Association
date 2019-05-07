package service;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.dbutils.DbUtils;

import util.DaoUtils;

import dao.UserDao;
import javabean.User;
import factory.BasicFactory;

public class UserServiceImpl implements UserService{
	private static final int user_id = 0;
	private UserDao dao = BasicFactory.getFactory().getDao(UserDao.class);
	public void regist(User user) {
		//1.校验用户名是否已经存在
//		if(dao.findUserByName(user.getUsername())!=null){	
//			throw new RuntimeException("用户名已经存在!!");
//		}
		
		dao.addUser(user);
		
	}

	

	public User getUserByNameAndPsw(String username, String password) {
		// TODO Auto-generated method stub
		return  dao.finUserByNameAndPsw(username,password);
	}

	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return dao.findUserByName(username);
	}



	public void updateUser(User user) {
		dao.updateUser(user);
		
	}



	public User findUserById(String id) {
		// TODO Auto-generated method stub
		return dao.findUserById(id);
	}



	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}



	public void delUser(String id) {
		
		 dao.delUser(id);
		
	}



	public void AdminupdateUser(User user) {
		dao.AdminupdateUser(user);
		
	}



	public List<User> AdminfindUserByName(String userName) {
		// TODO Auto-generated method stub
		return dao.AdminfindUserByName(userName);
	}



	public void batchDel(String[] ids) {
		// TODO Auto-generated method stub
		java.sql.Connection conn = DaoUtils.getConn();
		try{
			conn.setAutoCommit(false);
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}



	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		return dao.findUserByName(username);
	}


	

}
