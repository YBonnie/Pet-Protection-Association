package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.jdbc.Connection;

import util.DaoUtils;
import util.TransactionManager;
import javabean.Adopt;
import javabean.User;

public class AdoptionDaoImpl implements AdoptionDao{

	public void addAdoption(Adopt adopt) {
		String sql = "insert into aptform values(null,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,adopt.getUserId(),adopt.getAptName(),adopt.getAptGender(),adopt.getAptId(),adopt.getAptBirthday(),adopt.getAptAddress(),adopt.getAptMobile(),adopt.getAptEmail(),adopt.getAptImage(),adopt.getPet_name(),adopt.getPet_id());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public List<Adopt> findAllAdopt() {
		String sql = "select * from aptform order by id desc";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Adopt>(Adopt.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Adopt findAdoptById(String id) {
		String sql = "select * from aptform where id = ?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Adopt>(Adopt.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delAdoption(String id) {
		// TODO Auto-generated method stub
				String sql = "delete from aptform where id = ?";
				try{
					QueryRunner runner = new QueryRunner(TransactionManager.getSource());
					runner.update(sql,id);
				}catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
		
	}

	public void AdminupdateAdoption(Adopt adopt) {
		// TODO Auto-generated method stub
		String sql = "update aptform set aptName = ? ,aptGender = ? ,aptAddress = ? ,aptMobile = ? ,aptEmail = ? ,pet_name = ? , pet_id = ? where id=?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,adopt.getAptName(),adopt.getAptGender(),adopt.getAptAddress(),adopt.getAptMobile(),adopt.getAptEmail(),adopt.getPet_name(),adopt.getPet_id(),adopt.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
		
	}

	public List<Adopt> AdminfindAdoptByName(String aptName) {
		String sql = "select * from aptform where aptName = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Adopt>(Adopt.class),aptName);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delCustByIDWithTrans(java.sql.Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from aptform where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
		
	}

	

}
