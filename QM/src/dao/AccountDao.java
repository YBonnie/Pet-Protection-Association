package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javabean.Account;
import javabean.Adopt;


public interface AccountDao extends Dao{
	public Account findAccountById(String id) ;

	public List<Account> findAllAccount();
	public void addAccount(Account account) ;
	int getCountRow();
	List<Account> getAccountByPage(int from, int count);
	/**
	 * 根据账单时间查询*/
	public List<Account> findAccountTimer(String accountDate);
	/**
	 * 根据ID删除账单列表*/
	public void delAccount(String id);
	/**
	 * 更新账户信息*/
	public void updateAccount(Account account);
	
	void delCustByIDWithTrans(Connection conn, String id) throws SQLException;
	
}
