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

import javabean.Account;
import javabean.Adopt;
import javabean.Dynamics;

public class AccountDaoImpl implements AccountDao{

	public Account findAccountById(String id) {
		String sql = "select * from account where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Account>(Account.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Account> findAllAccount() {
		String sql = "select * from account order by timer desc";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Account>(Account.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void addAccount(Account account) {
		String sql = "insert into account values(null,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,account.getTimer(),account.getTitle(),account.getUrl(),account.getAccountimg());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public int getCountRow() {
		String sql = "select count(*) from account";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Account> getAccountByPage(int from, int count) {
		String sql = "select * from account order by timer desc limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Account>(Account.class),from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Account> findAccountTimer(String accountDate) {
		String sql = "select * from account where timer = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Account>(Account.class),accountDate);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delAccount(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from account where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}

	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		String sql = "update account set timer = ? ,title = ? ,url = ? ,accountimg = ? where id=?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,account.getTimer(),account.getTitle(),account.getUrl(),account.getAccountimg(),account.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from account where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}

}
