package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.DaoUtils;
import util.TransactionManager;

import javabean.User;

public class UserDaoImpl implements UserDao {

	
	public User findUserByName(String username) {
		String sql = "select * from users where username = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class),username);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	
	public void addUser(User user) {
		String sql = "insert into users values(null,?,?,?,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,user.getUsername(),user.getPassword1(),user.getPassword2(),user.getTruename(),user.getChineseId(),user.getEmail(),user.getPhone());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}


	public void delUser(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from users where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "update users set username = ? ,password1 = ? ,truename = ? ,chineseId = ? ,email = ? ,phone = ?  where id=?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,user.getUsername(),user.getPassword1(),user.getTruename(),user.getChineseId(),user.getEmail(),user.getPhone(),user.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
		
	}

	public User finUserByNameAndPsw(String username, String password) {
		String sql = "select * from users where username = ? and password1 = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class) ,username ,password);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	


	public User findUserById(String id) {
		String sql = "select * from users where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public List<User> getAllUser() {
		String sql = "select * from users";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<User>(User.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}


	public User findUserById(int id) {
		String sql = "select * from users where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public void AdminupdateUser(User user) {
		// TODO Auto-generated method stub
				String sql = "update users set username = ? ,password1 = ? ,email = ? ,phone = ?  where id=?";
				try{
					QueryRunner runner = new QueryRunner(TransactionManager.getSource());
					runner.update(sql,user.getUsername(),user.getPassword1(),user.getEmail(),user.getPhone(),user.getId());
				}catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}	
		
	}


	public List<User> AdminfindUserByName(String userName) {
		String sql = "select * from users where username = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<User>(User.class),userName);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from users where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}
	

}
