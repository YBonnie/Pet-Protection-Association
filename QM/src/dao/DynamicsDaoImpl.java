package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import util.DaoUtils;
import util.TransactionManager;

import javabean.Dynamics;
import javabean.News;


public class DynamicsDaoImpl implements DynamicsDao{

	public Dynamics findDynamicsById(String id) {
		String sql = "select * from dynamics where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Dynamics>(Dynamics.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Dynamics> findAllDynamics() {
		String sql = "select * from dynamics order by dynamics_time desc";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Dynamics>(Dynamics.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void addDynamics(Dynamics dynamics) {
		String sql = "insert into dynamics values(null,?,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,dynamics.getDynamics_title(),dynamics.getDynamics_time(),dynamics.getDynamics_content(),dynamics.getDynamics_allcont(),dynamics.getDynamics_img());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int getCountRow() {
		String sql = "select count(*) from dynamics";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Dynamics> getDynamicsByPage(int from, int count) {
		String sql = "select * from dynamics order by dynamics_time desc limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Dynamics>(Dynamics.class),from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Dynamics> findDynamicsTitle(String findDynaTitle) {
		String sql = "select * from dynamics where dynamics_title = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Dynamics>(Dynamics.class),findDynaTitle);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delDynamics(String id) {
		// TODO Auto-generated method stub
				String sql = "delete from dynamics where id = ?";
				try{
					QueryRunner runner = new QueryRunner(TransactionManager.getSource());
					runner.update(sql,id);
				}catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}	
		
	}

	public void updateDynamics(Dynamics dynamics) {
		// TODO Auto-generated method stub
		String sql = "update dynamics set dynamics_title = ? ,dynamics_time = ? ,dynamics_content = ? ,dynamics_allcont = ? ,dynamics_img = ? where id=?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,dynamics.getDynamics_title(),dynamics.getDynamics_time(),dynamics.getDynamics_content(),dynamics.getDynamics_allcont(),dynamics.getDynamics_img(),dynamics.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from dynamics where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}

	

	

}
