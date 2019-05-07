package service;

import java.util.List;

import javabean.Account;
import javabean.Page;

public interface AccountService  extends Service{
	Account findAccountById(String id);

	List<Account> findAllAccount();
	/**
	 * 分页查询客户的方法
	 * @param thispage 当前页码
	 * @param rowperpage 每页记录数
	 * @return 当前页所有信息
	 */
	Page pageAccount(int thispage, int rowperpage);
	
	/**
	 * 根据账单时间查询*/
	List<Account> findAccountTimer(String accountDate);
	/**
	 * 根据ID删除账单列表*/
	void delAccount(String id);
	/**
	 * 添加账单*/
	void addAccounts(Account account);
	/**
	 * 更新账单数据*/
	void updateAccounts(Account account);
	
	void batchDel(String[] ids);

}
