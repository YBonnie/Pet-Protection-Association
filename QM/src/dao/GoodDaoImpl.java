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

import javabean.Good;
import javabean.Pet;

public class GoodDaoImpl implements GoodDao{

	public Good findGoodById(String id) {
		String sql = "select * from goods where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Good>(Good.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Good> findAllGood() {
		String sql = "select * from goods order by id desc";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Good>(Good.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void addGood(Good good) {
		String sql = "insert into goods values(null,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,good.getName(),good.getPrice(),good.getTotal_number(),good.getImgurl());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int getCountRow() {
		String sql = "select count(*) from goods";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Good> getGoodByPage(int from, int count) {
		String sql = "select * from goods order by id desc limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Good>(Good.class),from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}



	public Good findGoodById(int id) {
		String sql = "select * from goods where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Good>(Good.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delPnum(int Product_id, int buynum) throws SQLException {
		String sql = "update goods set total_number = total_number-? where id = ? and total_number-?>=0";
		QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		int count = runner.update(sql,buynum,Product_id,buynum);
		if(count<=0){
			throw new SQLException("false");
		}
		
	}

	public void addPnum(int product_id, int buynum) {
		String sql = "update goods set total_number = total_number+? where id = ? ";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,buynum,product_id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public List<Good> findGoodsName(String goodsName) {
		String sql = "select * from goods where name = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Good>(Good.class),goodsName);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delGoods(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from goods where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updateGoods(Good goods) {
		// TODO Auto-generated method stub
		String sql = "update goods set name = ? ,price = ? ,total_number = ? ,imgurl = ? where id=?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,goods.getName(),goods.getPrice(),goods.getTotal_number(),goods.getImgurl(),goods.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from goods where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}



	

	
	
	
}
