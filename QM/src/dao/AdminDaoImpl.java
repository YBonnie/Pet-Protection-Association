package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import util.TransactionManager;
import javabean.Admin;
import javabean.User;


public class AdminDaoImpl implements AdminDao {

	public Admin findAdminByName(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from adminer where ad_name = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Admin>(Admin.class),username);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public Admin finAdminByNameAndPsw(String username, String password) {
		String sql = "select * from adminer where ad_name = ? and ad_password = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Admin>(Admin.class) ,username ,password);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Admin findAdminById(String id) {
		String sql = "select * from adminer where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Admin>(Admin.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
				String sql = "update adminer set ad_name = ? ,ad_password = ? ,ad_phone = ? where id=?";
				try{
					QueryRunner runner = new QueryRunner(TransactionManager.getSource());
					runner.update(sql,admin.getAd_name(),admin.getAd_password(),admin.getAd_phone(),admin.getId());
				}catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}	
		
	}


}
