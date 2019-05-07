package service;

import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import util.DaoUtils;

import dao.AccountDao;
import factory.BasicFactory;

import javabean.Account;
import javabean.Dynamics;
import javabean.Page;

public class AccountServiceImpl implements AccountService{
	private AccountDao dao = BasicFactory.getFactory().getDao(AccountDao.class);
	public Account findAccountById(String id) {
		// TODO Auto-generated method stub
		return dao.findAccountById(id);
	}

	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return dao.findAllAccount();
	}

	public Page pageAccount(int thispage, int rowperpage) {
		Page page = new Page();
		//--当前页
		page.setThispage(thispage);
		//--每页记录数
		page.setRowperpage(rowperpage);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//--下一页
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--当前页数据
		List<Account> list = dao.getAccountByPage((thispage-1)*rowperpage,rowperpage);
		for (Account account : list) {
			System.out.println(account);
		}
		page.setList3(list);
		
		return page;
	}

	public List<Account> findAccountTimer(String accountDate) {
		// TODO Auto-generated method stub
		return dao.findAccountTimer(accountDate);
	}

	public void delAccount(String id) {
		// TODO Auto-generated method stub
		dao.delAccount(id);
	}

	public void addAccounts(Account account) {
		// TODO Auto-generated method stub
		dao.addAccount(account);
	}

	public void updateAccounts(Account account) {
		// TODO Auto-generated method stub
		dao.updateAccount(account);
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

}
